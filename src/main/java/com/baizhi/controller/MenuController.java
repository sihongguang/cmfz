package com.baizhi.controller;

import com.baizhi.Util.ResultView;
import com.baizhi.entity.BuddhaMenu;
import com.baizhi.service.BuddhaMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private BuddhaMenuService buddhaMenuService;

    @RequestMapping("queryAllBudd")
    @ResponseBody
    public List<BuddhaMenu> queryAllBudd(){

        List<BuddhaMenu> buddhaMenus = buddhaMenuService.queryallBuddhaMenu();
        return buddhaMenus;
    };

    @RequestMapping("verifyLog")
    @ResponseBody
    public ResultView verifyLog(HttpSession session){
        System.out.println("verify");
        ResultView rv=new ResultView();
        Object admin = session.getAttribute("admin");
        if (admin!=null){
            rv.setVerify(true);
            rv.setContent("成功");
        }else{
            rv.setVerify(false);
            rv.setContent("失败");
        }
        return rv;
    };
}
