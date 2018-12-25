package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDAO extends BaseDAO<User>{

    void  updateUser(User user);

}
