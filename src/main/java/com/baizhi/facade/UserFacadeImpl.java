package com.baizhi.facade;

import com.baizhi.Util.MD5Util;
import com.baizhi.Util.SaltUit;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class UserFacadeImpl implements  UserFacade{

    @Autowired
    private UserService userService;


    @Override
    public Boolean addUserVerify(String name) {
        User user = userService.queryUser(name);
        if (user!=null){
            return true;
        }
        throw new RuntimeException("用户名已存在");
    }

    @Override
    public List<User> queryAllUser() {
        List<User> users = userService.queryAllUser();
        return users;
    }

    @Override
    public void addUser(User user, HttpServletRequest request, MultipartFile addFile) throws IOException {
        /*获得头像文件*/
        final String url="/upload";
        String uuid = UUID.randomUUID().toString();
        int i = uuid.hashCode();//得到我的uuid 的哈希码值
        String hash = String.valueOf(i);//转换为字符串


        String realPath = request.getSession().getServletContext().getRealPath(url);//得到绝对路径
        String originalFilename = addFile.getOriginalFilename();//得到文件名称
        String filename=hash+originalFilename;
        String profilePath=url+"/"+filename;
        addFile.transferTo(new File(realPath,filename));//添加文件


        //用户模块
        user.setProfile(profilePath);
        user.setStatus("Y");
        user.setRegistertime(new Date());
        user.setUserid(uuid);
        String randomSaltCode = SaltUit.generetRandomSaltCode();//加严
        user.setSalt(randomSaltCode);//加严
        String password = user.getPassword();
        String md5Code = MD5Util.getMd5Code(hash+uuid+password+randomSaltCode);//加密

        user.setPassword(md5Code);

        userService.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userService.updateUser(user);
    }

    @Override
    public Boolean loginUser(String phone, String password, HttpSession session) {
        User user = userService.queryUser(phone);
        if(user!=null){
            String salt = user.getSalt();
            String userid = user.getUserid();
            int i = userid.hashCode();
            String hash = String.valueOf(i);
            String passwordMD5 = MD5Util.getMd5Code(hash+userid+password+salt);

            if(user.getPassword().equals(passwordMD5)){
                session.setAttribute("user",user);
                return true;
            }else{
                throw new RuntimeException("密码错误");//用户名不正确
            }
        }else{
            throw new RuntimeException("用户名错误");//密码不正确
        }
    }
}
