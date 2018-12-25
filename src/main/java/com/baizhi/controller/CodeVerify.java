package com.baizhi.controller;

import com.baizhi.Util.RandomNumUtil;
import com.baizhi.Util.ResultView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RequestMapping("code")
@Controller
public class CodeVerify {

    @RequestMapping("code")
    public void Verify(HttpServletResponse response, HttpSession session)throws IOException {
         /*
             1.生成验证码
             2.把验证码上的文本存在session中
             3.把验证码图片发送给客户端
             */
        RandomNumUtil v=new RandomNumUtil();    //用我们的验证码类，生成验证码类对象
        BufferedImage image=v.getImage();  //获取验证码
        session.setAttribute("text", v.getText()); //将验证码的文本存在session中
        v.output(image, response.getOutputStream());//将验证码图片响应给客户端
    }

    @RequestMapping("/verifyEncode")
    @ResponseBody
    public ResultView verifyEncode(HttpSession session,String encode){
        ResultView rv=new ResultView();
        String text = (String) session.getAttribute("text");//得到验证码字符串
        if (encode.equals(text)){//判断字符内容是否等于网页接收的验证码
            rv.setVerify(true);//正确处理
            rv.setContent("正确");
        }else {
            rv.setVerify(false);//错误处理
            rv.setContent("错误");
            }
        return rv;//返回结果对象
    }
}
