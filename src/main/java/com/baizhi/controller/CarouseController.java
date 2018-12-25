package com.baizhi.controller;

import com.baizhi.Util.ResultView;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Carouse;
import com.baizhi.facade.AlbumFacade;
import com.baizhi.service.CarouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
@Controller
@RequestMapping("carouse")
public class CarouseController {
    @Autowired
    private CarouseService carouseService;

    @RequestMapping("queryAllCarouse")
    @ResponseBody
    public List<Carouse> queryAllCarouse(){
        List<Carouse> queryall = carouseService.queryall();
        System.out.println(queryall);
        return queryall;
    }

    @RequestMapping("addCarouse")
    @ResponseBody
    public ResultView addCarouse(HttpSession session, HttpServletRequest request, Carouse carouse, MultipartFile filename) throws IOException {
        final String  URL="/carouseimg";
        System.out.println("进入");
        ResultView rv=new ResultView();
        try{
            String realPath = request.getSession().getServletContext().getRealPath(URL);//绝对路径
            Admin admin = (Admin) session.getAttribute("admin");//取出用户
            String filenameOriginalFilename = filename.getOriginalFilename();//文件名称
            filename.transferTo(new File(realPath,filenameOriginalFilename));//添加到文件夹
            String str=URL+"/"+filenameOriginalFilename;

            carouseService.addCarouse(carouse,str,admin.getAdminname());//调用业务
            rv.setContent("成功");
            rv.setVerify(true);
        }catch (Exception e){
            rv.setContent("失败");
            System.out.println(e.toString());
            rv.setVerify(false);
         }
        return rv;
    }


    @ResponseBody
    @RequestMapping("updateStatus")
    public ResultView updateStatus(Carouse carouse){
        ResultView rv=new ResultView();
        try{
            carouseService.upDateStatus(carouse);
            rv.setVerify(true);
            rv.setContent("成功");
        }catch (Exception e){
            rv.setVerify(false);
            rv.setContent("失败");
            System.out.println(e.toString());
        }
        return rv;
    }

    @RequestMapping("updateShowCarouse")
    @ResponseBody
    public Carouse updateShowCarouse(String carouseid){
        Carouse  carouse= carouseService.queryByID(carouseid);
        return carouse;
    }

    @ResponseBody
    @RequestMapping("UpdateForName")
    public ResultView UpdateForName(Carouse carouse){
        ResultView rv=new ResultView();
        try{
            carouseService.UpdateForName(carouse);
            rv.setVerify(true);
            rv.setContent("成功");
        }catch (Exception e){
            rv.setVerify(false);
            rv.setContent("失败");
            System.out.println(e.toString());
        }
        return rv;
    }
}
