package com.baizhi.service;

import com.baizhi.Util.MD5Util;
import com.baizhi.Util.SaltUit;
import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;


    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void addUser(User user){

        userDAO.insert(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> queryAllUser() {
        return userDAO.queryall();
    }

    @Override
    public User queryUser(String phone) {
        User user = userDAO.queryByStr(phone);
        return user;
    }
}
