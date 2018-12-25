package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 上师实体类
 * */
public class Guru {
    private String guruid;//大师的id
    private String guruname;//大师的名字
    private String profile;//头像
    private String gender;//性别
    private String gurustatus;//状态
    private String createname;//创建者名称

    @JSONField(format="yyyy/MM/dd")
    private Date  createtime;//创建时间
    private List<Article> children;
    private String ex4;
    private String ex5;

    @Override
    public String toString() {
        return "Guru{" +
                "guruid='" + guruid + '\'' +
                ", guruname='" + guruname + '\'' +
                ", profile='" + profile + '\'' +
                ", gender='" + gender + '\'' +
                ", gurustatus='" + gurustatus + '\'' +
                ", createname='" + createname + '\'' +
                ", createtime=" + createtime +
                ", ex4='" + ex4 + '\'' +
                ", ex5='" + ex5 + '\'' +
                ", children=" + children +
                '}';
    }

    public Guru(String guruid, String guruname, String profile, String gender, String gurustatus, String createname, Date createtime, String ex4, String ex5, List<Article> children) {
        this.guruid = guruid;
        this.guruname = guruname;
        this.profile = profile;
        this.gender = gender;
        this.gurustatus = gurustatus;
        this.createname = createname;
        this.createtime = createtime;
        this.ex4 = ex4;
        this.ex5 = ex5;
        this.children = children;
    }

    public String getGuruid() {
        return guruid;
    }

    public void setGuruid(String guruid) {
        this.guruid = guruid;
    }

    public String getGuruname() {
        return guruname;
    }

    public void setGuruname(String guruname) {
        this.guruname = guruname;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGurustatus() {
        return gurustatus;
    }

    public void setGurustatus(String gurustatus) {
        this.gurustatus = gurustatus;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public List<Article> getChildren() {
        return children;
    }

    public void setChildren(List<Article> children) {
        this.children = children;
    }

    public Guru() {
    }
}
