package com.baizhi.entity;
/*
* 管理员实体类
* */
public class Admin {
    private String adminid;//管理员id
    private  String adminname;//管理员名字
    private  String createdate;//添加管理员时间
    private  String state;//管理员状态
    private  String password;//管理员密码
    private  String  ajaxverify;//极限数据验证

    public Admin(String adminid, String adminname, String createdate, String state, String password, String ajaxverify) {
        this.adminid = adminid;
        this.adminname = adminname;
        this.createdate = createdate;
        this.state = state;
        this.password = password;
        this.ajaxverify = ajaxverify;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminid='" + adminid + '\'' +
                ", adminname='" + adminname + '\'' +
                ", createdate='" + createdate + '\'' +
                ", state='" + state + '\'' +
                ", password='" + password + '\'' +
                ", ajaxverify='" + ajaxverify + '\'' +
                '}';
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAjaxverify() {
        return ajaxverify;
    }

    public void setAjaxverify(String ajaxverify) {
        this.ajaxverify = ajaxverify;
    }
}
