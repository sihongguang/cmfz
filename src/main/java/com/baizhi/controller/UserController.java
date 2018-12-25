package com.baizhi.controller;

import com.baizhi.Util.MD5Util;
import com.baizhi.Util.ResultView;
import com.baizhi.Util.SaltUit;
import com.baizhi.entity.User;
import com.baizhi.facade.UserFacade;
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

@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    private UserFacade userFacade;

    /*查询所有*/
    @RequestMapping("queryAllUser")
    @ResponseBody
    public List<User> queryAllUser(){
        List<User> users = userFacade.queryAllUser();
        return users;
    }

    /*添加对象*/
    @RequestMapping("addUser")
    public String addUser(User user, HttpServletRequest request, MultipartFile addFile) throws IOException {
        userFacade.addUser(user,request,addFile);
        return "redirect:/Userlogin.jsp";
    }


    /*用户修改*/
    @RequestMapping("updateUser")
    public String  updateUser(User user,MultipartFile addFile,HttpServletRequest request) throws IOException {
        final String url="/upload";

        String userid = user.getUserid();
        int i =userid.hashCode();
        String hash = String.valueOf(i);
        if (addFile!=null&&!(addFile.getOriginalFilename().equals(""))){
            String realPath = request.getSession().getServletContext().getRealPath(url);//得到绝对路径
            String originalFilename = addFile.getOriginalFilename();//得到文件名称
            String filename=hash+originalFilename;
            String profilePath=url+"/"+filename;
            addFile.transferTo(new File(realPath,filename));//添加文件
            user.setProfile(profilePath);
        }
        System.out.println(user);
        if(user.getPassword().equals("")){
            user.setPassword(null);
        }else {
            String salt = user.getSalt();
            String password = user.getPassword();
            String md5Code = MD5Util.getMd5Code(hash+userid+password+salt);//加密
            user.setPassword(md5Code);
        }
        userFacade.updateUser(user);
        return "redirect:/Userlogin.jsp";
    }

    /*状态修改*/
    @RequestMapping("updateUserStatus")
    @ResponseBody
    public ResultView updateUserStatus(User user){
        ResultView rv=new ResultView();
        try{
            if(user.getStatus().equals("true")){
                user.setStatus("false");
                System.out.println(user+"tru'e");
                System.out.println("进入true");
            }else {
                user.setStatus("true");
                System.out.println(user+"false");
                System.out.println("进入else");
            }
            userFacade.updateUser(user);
            rv.setVerify(true);
            rv.setContent("成功");
        }catch(Exception e){
            rv.setVerify(false);
            rv.setContent("失败");
        }
        return rv;
    }

    /*用户的登陆*/
    @RequestMapping("login")
    public String loginUser(String phone, String password,HttpSession session){

            Boolean aBoolean = userFacade.loginUser(phone, password,session);
            if(aBoolean){
                return "redirect:/updateUser.jsp";
            }

        return "redirect:/Userlogin.jsp";//返回视图对象
    }
}
