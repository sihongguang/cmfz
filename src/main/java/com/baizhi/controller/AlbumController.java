package com.baizhi.controller;

import com.baizhi.Util.PageUtil;
import com.baizhi.Util.ResultView;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.facade.AlbumFacade;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@RequestMapping("album")
@Controller
public class AlbumController {


    @Autowired
    private ChapterService chapterService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private  AlbumFacade albumFacade;

    @RequestMapping("queryAll")
    @ResponseBody
    public PageUtil<Album> queryAllAlbum(Integer page,Integer rows){
        PageUtil<Album> albumPageUtil=new PageUtil<Album>();
        List<Album> albums = albumService.queryAll(page,rows);
        albumPageUtil.setRows(albums);
        Integer queryCount = albumService.queryCountAlbum();
        albumPageUtil.setTotal(queryCount);
        return albumPageUtil;
    }

    @RequestMapping("addAlbum")
    @ResponseBody
    public ResultView addAlbum(Album album, MultipartFile addFile, HttpServletRequest request){
        ResultView rv=new ResultView();
        final String UPLOAD = "/upload";
       try{
           String realPath = request.getSession().getServletContext().getRealPath(UPLOAD);//获得绝对路径
           String filename = addFile.getOriginalFilename();//获得文件名
           String uuid = UUID.randomUUID().toString();//获得UUID
           album.setId(uuid);
           albumService.addAlbum(album,UPLOAD,uuid+filename);//传入对象,相对路径,文件名
           addFile.transferTo(new File(realPath,uuid+filename));
           System.out.println(album);
           rv.setContent("成功");
            rv.setVerify(true);
       }catch (Exception e){
           rv.setVerify(false);
           rv.setContent("失败");
           String s = e.toString();
           System.out.println(s);
       }
        return rv;
    }

    /*思路分析
    *
    *  第一步接收从网页传递的参数进行查询,作为对删除文件的数据支撑
    *  第二: 进行删除文件操作
    *  第三: 进行数据库删除操作
    *  第四: 使用自定义类对网页返回操作结果
    * */
    @RequestMapping("deleteAlbum")
    @ResponseBody
    public ResultView deleteAlbum(Album album,HttpServletRequest request){
        ResultView rv=new ResultView();
        System.out.println("进入控制层");
        /*第一步开始*/
      try{
          albumFacade.AlbumDeleteFile(album,request);
          rv.setContent("成功");
          rv.setVerify(true);
      }catch(Exception e){
          rv.setVerify(false);
          rv.setContent("失败");
          System.out.println(e.toString());
      }
        return rv;
    }

}
