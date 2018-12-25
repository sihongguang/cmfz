package com.baizhi.controller;

import com.baizhi.Util.ResultView;
import com.baizhi.entity.Chapter;
import com.baizhi.facade.AlbumFacade;
import com.baizhi.service.ChapterService;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;

@RequestMapping("chapter")
@Controller
public class ChapterController {

    @Autowired
    private ChapterService chapterService;
    @Autowired
    private AlbumFacade albumFacade;

    /*
    * 思路分析:
    *   第一 接收网页的文件和我的属性
    *   第二 将我所接收的文件进行拆分和重组到我的对象中去
    *   (细节在创建的时候进行一些分类的处理就可以做到对于文件的下载的文件夹的动态修改)
    *   第三 将我的对象存入数据库 将我的文件进行UUID 拼接来实现 文件的不重名
    *   第四 通过我自己设置RsultVIew类进行返回ajax
    * */
    @RequestMapping("addChapter")
    @ResponseBody
    public ResultView addChapter(HttpServletRequest request, String chapterPid,String title, MultipartFile filefrequency){
        /*
        * 实现第一步
        * */
        Chapter chapter = new Chapter();
         String URL="/upload";//文件路径将不会存入数据库而是以配置文件的形式来进行修改来使用
        ResultView rv=new ResultView();//决定返回对象
        String uuid = UUID.randomUUID().toString();
        //第一步结束

        //第二步开始
        //使用try
        try{
            String realPath = request.getSession().getServletContext().getRealPath(URL);//获得绝对路径
            String filename = filefrequency.getOriginalFilename();//获得文件名字
            long size = filefrequency.getSize();//得到文件长度

            //进行重组

            long filesize=(size/1024)/1024;//得到我需要存入数据库的长度

            String fileSizeString = String.valueOf(filesize);//数据类型转换 准备存入对象
            /*组装开始*/

            chapter.setId(uuid);//添加uuid

            chapter.setSize(fileSizeString+"M");//存入对象

            chapter.setTitle(title);//获得章节名称

            chapter.setAlbumtitle(filename);//将我的章节的文件的名字存入我的albumtitle

            String downpath=filename;//下载路径

            String uploadFilename=uuid+filename;//上传文件名

            String realfile=uuid+filename;//通过拼接来得到不会重复的相对路径的名字

            File file = new File(realPath,realfile);//得到文件

            filefrequency.transferTo(file);//进行文件上传操作

            chapter.setDownpath(downpath);//存储下载路径

            String duration = getTimeOut(file);//获得时长

            chapter.setDuration(duration);//存储时长

            chapter.setAlbumid(chapterPid);//放入父类id

            chapter.setUploaddate(new Date());//添加时间

            /*第二步结束 第三步开始*/
            chapterService.addChapter(chapter);//进行业务层的传递

            albumFacade.addCount(chapterPid);//根据Pid 查询 并且 得到对象之后 修改 存在集数
           //第三步 结束

           // 第四步开始
            rv.setVerify(true);//使用我的对象ajax 返回展示判断
            rv.setContent("成功");//返回的内容
        }catch (Exception e){//出现错误的时候进行的返回
            System.out.println(e.toString());
            rv.setVerify(false);
            rv.setContent("失败");
        }
        System.out.println(rv);
        return rv;
    }


//获得文件时长
    public static String getTimeOut(File source) throws EncoderException {
        Encoder encoder = new Encoder();
        String time="00:00";
        try {
            MultimediaInfo m = encoder.getInfo(source);

            int second=(int)m.getDuration()/1000%60;
            int minute=(int)m.getDuration()/1000/60;
            time=minute+":"+second;
            System.out.println(time);
        } catch (Exception e) {
            System.out.println("获取音频时长有误：" + e.getMessage());
        }
        return time;
    }

    /*
    *
    * 思路分析(下载的本质就是通过流的形式进行COPY 的操作)
    *   第一 得到属性之后进行查询
    *   第二 根据查询开始下载操作的数据传递
    *   第三步响应浏览器请求
    * */

    @RequestMapping("downloadChapter")
    public String downloadFile(HttpServletRequest request, String id, HttpServletResponse response) throws IOException {

        final  String url="/upload";//获得文件夹的位置

        //第一步开始
        //根据数据查询为下载做数据支撑
        Chapter chapter = chapterService.queryByid(id);
        //第一步结束
        //第二步开始
        String realPath = request.getSession().getServletContext().getRealPath(url);//得到绝对路径

        String chapterFileName= chapter.getAlbumtitle();//得到章节文件的名称
        String chapterId = chapter.getId();//得到章节的唯一标识

        String downloadFileName =chapterId+chapterFileName;//得到我的存储的文件的真正的文件的名称
        FileInputStream fileInputStream = new FileInputStream(new File(realPath, downloadFileName));
        //第二部结束
        System.out.println(downloadFileName);

        //改变响应类型 下载或者在线浏览 (输出流)
        response.setHeader("content-disposition","attachment;fileName="
                + URLEncoder.encode(downloadFileName,"UTF-8"));//响应浏览器的下载请求并设置响应时所显示的文件的名称及其编码格式

        //获得输出流
        ServletOutputStream outputStream = response.getOutputStream();

        /*使用spring所带有的文件的上传和下载的工具类来实现文件的下载*/
        IOUtils.copy(fileInputStream,outputStream);
        //进行关流
        IOUtils.closeQuietly(fileInputStream);//关闭输出流
        IOUtils.closeQuietly(outputStream);//关闭输入流

        return "index";
    };
}
