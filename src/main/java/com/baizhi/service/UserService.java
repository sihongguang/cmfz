package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    //修改
    void updateUser(User user);
    //添加
    void addUser(User user);
    //查询所有
    List<User> queryAllUser();
    //查询用户
    User queryUser(String phone);
}
