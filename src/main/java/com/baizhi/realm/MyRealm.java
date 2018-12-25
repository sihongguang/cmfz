package com.baizhi.realm;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;


public class MyRealm extends AuthenticatingRealm {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken up=(UsernamePasswordToken)authenticationToken;
        String username = up.getUsername();
        Admin admin = adminDAO.queryByStr(username);
        if(username.equals(admin.getAdminname())){
           return  new SimpleAccount(admin.getAdminname(),admin.getPassword(),admin.getAdminid());

        }
        return null;
    }
}
