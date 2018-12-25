package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDAO adminDAO;

    @Transactional(propagation = Propagation.SUPPORTS)

    @Override
    public Admin queryAdminid(String name,String password) {
        Admin admin = adminDAO.queryByStr(name);//根据name 查询
        if(admin!=null){//判断是否存在
            if (admin.getPassword().equals(password)){//判断密码是否正确
                    return admin;
            }else{
                throw new RuntimeException("密码错误");//密码不正确
            }
        }else{
            throw new RuntimeException("用户名错误");//用户名不正确
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Admin queryAdminId(String name) {
        return adminDAO.queryByStr(name);
    }


    @Override
    public void updateAdmin(Admin admin) {
        adminDAO.updateAdmin(admin);
    }
}
