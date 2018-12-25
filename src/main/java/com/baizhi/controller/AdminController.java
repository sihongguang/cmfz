package com.baizhi.controller;

import com.baizhi.Util.ResultView;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 管理员登陆
     * */
    @RequestMapping("adminLogin")
    @ResponseBody
    public ResultView adminLogin(HttpSession session, String name, String password,String ajax){
        ResultView rv=new ResultView();//视图对象
        try {//try块
            Admin admin = adminService.queryAdminid(name, password);//传入service
            session.setAttribute("admin",admin);//将得到的结果放入session
            rv.setContent("成功");
            rv.setVerify(true);//成功
        }catch (RuntimeException e){//捕获异常
            int i = e.toString().indexOf(":");//获得异常内容
            rv.setContent(e.toString().substring(i+1));
            rv.setVerify(false);
        }
        System.out.println(rv);
        return rv;//返回视图对象
    }


    @RequestMapping("adminLoginShiro")
    @ResponseBody
    public ResultView adminLoginShiro(HttpSession session, String adminName, String password,Boolean rm){
        ResultView rv=new ResultView();//视图对象
        try {//try块
            Subject subject = SecurityUtils.getSubject();
            System.out.println(adminName+"+======"+password);

            Boolean remeberMe = Boolean.valueOf(rm);//转换为我的boolean 类型

            System.out.println(remeberMe+"-----------");

            subject.login(new UsernamePasswordToken(adminName,password,remeberMe));
            System.out.println(subject.isAuthenticated());
            Admin admin = adminService.queryAdminid(adminName, password);//传入service
            session.setAttribute("admin",admin);//将得到的结果放入session
            rv.setContent("成功");
            rv.setVerify(true);//成功
        } catch (UnknownAccountException u){
            rv.setContent("账号不存在");
            rv.setVerify(false);
        } catch(IncorrectCredentialsException credentialsException){
            rv.setContent("密码错误");
            rv.setVerify(false);
        }catch (Exception e){

            rv.setContent("账号不存在或者账号输入有误");
            rv.setVerify(false);
        }
        System.out.println("成功");
        return rv;
    }



    @RequestMapping("updateShowAdmin")
    @ResponseBody
    public Admin updateShowAdmin(String name){//更新前展示
        Admin admin = adminService.queryAdminId(name);
        return admin;
    }

    @RequestMapping(value = "/updateAdmin")
    @ResponseBody
    public ResultView updateAdmin(Admin admin){//修改信息
        ResultView rv=new ResultView();
        try{

            adminService.updateAdmin(admin);
            rv.setVerify(true);
            rv.setContent("成功");
        }catch(Exception e){
            rv.setVerify(false);
            rv.setContent("失败");
        }
        return rv;
    }

    @RequestMapping("constraintLogin")
    @ResponseBody
    public void constraintLogin(HttpSession session){//关闭session
            session.removeAttribute("admin");
    }
}
