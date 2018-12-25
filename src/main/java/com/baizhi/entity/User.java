package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class User {
    private String userid;//用户id
    private String username;//用户名字
    private String profile;//头像
    private String nikename;//昵称
    private String gender;//性别
    private String province;//省份
    private String city;//市
    private String sign;//签名
    @JSONField(format="yyyy/MM/dd")
    private Date   registertime;//创建时间
    private String status;//状态
    private String password;//密码
    private String phone;//手机号
    private String salt;//盐值
    private String ex2;
    private String ex3;
    private String ex4;
    private String ex5;

    public User(String userid, String username, String profile, String nikename, String gender, String province, String city, String sign, Date registertime, String status, String password, String phone, String salt, String ex2, String ex3, String ex4, String ex5) {
        this.userid = userid;
        this.username = username;
        this.profile = profile;
        this.nikename = nikename;
        this.gender = gender;
        this.province = province;
        this.city = city;
        this.sign = sign;
        this.registertime = registertime;
        this.status = status;
        this.password = password;
        this.phone = phone;
        this.salt = salt;
        this.ex2 = ex2;
        this.ex3 = ex3;
        this.ex4 = ex4;
        this.ex5 = ex5;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", profile='" + profile + '\'' +
                ", nikename='" + nikename + '\'' +
                ", gender='" + gender + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", registertime=" + registertime +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", salt='" + salt + '\'' +
                ", ex2='" + ex2 + '\'' +
                ", ex3='" + ex3 + '\'' +
                ", ex4='" + ex4 + '\'' +
                ", ex5='" + ex5 + '\'' +
                '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEx2() {
        return ex2;
    }

    public void setEx2(String ex2) {
        this.ex2 = ex2;
    }

    public String getEx3() {
        return ex3;
    }

    public void setEx3(String ex3) {
        this.ex3 = ex3;
    }

    public String getEx4() {
        return ex4;
    }

    public void setEx4(String ex4) {
        this.ex4 = ex4;
    }

    public String getEx5() {
        return ex5;
    }

    public void setEx5(String ex5) {
        this.ex5 = ex5;
    }

    public User() {
    }
}
