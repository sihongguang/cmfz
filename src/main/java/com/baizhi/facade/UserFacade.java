package com.baizhi.facade;

import com.baizhi.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public interface UserFacade {

    Boolean addUserVerify(String name);
    //查询所有
    List<User> queryAllUser();
    //添加用户
    void addUser(User user, HttpServletRequest request, MultipartFile multipartFile) throws IOException;
    //修改用户
    void updateUser(User user);
    //用户登入
    Boolean loginUser(String  phone, String password, HttpSession session);

}
