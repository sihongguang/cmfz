package com.baizhi.controller;

import com.baizhi.Util.ResultView;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@RequestMapping("guru")
@Controller
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("queryAllGuru")
    @ResponseBody
    public List<Guru> queryallGuru(){
        List<Guru> gurus = guruService.queryallGuru();
        return gurus;
    }
    @ResponseBody
    @RequestMapping("addGuru")
    public ResultView addGuru(MultipartFile multipartFile, HttpServletRequest request ,Guru guru){
        final  String url="/guruprofile";
        ResultView rv=new ResultView();
        try{
            String filename = multipartFile.getOriginalFilename();
            String profile=url+"/"+filename;
            String realPath = request.getSession().getServletContext().getRealPath(url);
            multipartFile.transferTo(new File(realPath,filename));
            Admin admin = (Admin) request.getSession().getAttribute("admin");
            guruService.addGuru(guru,profile,admin.getAdminname());
            rv.setVerify(true);
            rv.setContent("成功");
        }catch (Exception e){
            rv.setVerify(false);
            rv.setContent("失败");
            System.out.println(e.toString());
        }
        return rv;
    };

    @RequestMapping("/updateGuru")
    @ResponseBody
    public ResultView updateGuru(String guruid,String guruname,String gurustatus){
        ResultView rv=new ResultView();
        Guru row=new Guru();
        row.setGuruname(guruname);
        row.setGurustatus(gurustatus);
        row.setGuruid(guruid);
        System.out.println(row);
        if (row.getGuruid()!=null )   {
            try{

                guruService.updateGuru(row);
                rv.setVerify(true);
                rv.setContent("成功");

            }catch (Exception e){
                rv.setVerify(false);
                rv.setContent("失败");
                System.out.println(e.toString());
            }
        }
        System.out.println(rv);
        return rv;
    }


}
