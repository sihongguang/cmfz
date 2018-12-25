package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    //登陆方法
    Admin queryAdminid(String name,String password);
    //id查询
    Admin queryAdminId(String name);
    //修改
    void updateAdmin(Admin admin);
}
