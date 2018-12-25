package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

/*
* 菜单实体类
* */
public class BuddhaMenu {
    private String menuid;//菜单id
    private String menuname;//菜单名称
    @JSONField(format="yyyy/MM/dd")
    private Date createdate;//创建时间
    private String imghead;//菜单头标
    private String grade;//级别
    private String parantid;//父类id
    private List<BuddhaMenu> menuList;
    private String href;//路径

    public BuddhaMenu(String menuid, String menuname, Date createdate, String imghead, String grade, String parantid, List<BuddhaMenu> menuList, String href) {
        this.menuid = menuid;
        this.menuname = menuname;
        this.createdate = createdate;
        this.imghead = imghead;
        this.grade = grade;
        this.parantid = parantid;
        this.menuList = menuList;
        this.href = href;
    }

    @Override
    public String toString() {
        return "BuddhaMenu{" +
                "menuid='" + menuid + '\'' +
                ", menuname='" + menuname + '\'' +
                ", createdate=" + createdate +
                ", imghead='" + imghead + '\'' +
                ", grade='" + grade + '\'' +
                ", parantid='" + parantid + '\'' +
                ", menuList=" + menuList +
                ", href='" + href + '\'' +
                '}';
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getImghead() {
        return imghead;
    }

    public void setImghead(String imghead) {
        this.imghead = imghead;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getParantid() {
        return parantid;
    }

    public void setParantid(String parantid) {
        this.parantid = parantid;
    }

    public List<BuddhaMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<BuddhaMenu> menuList) {
        this.menuList = menuList;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public BuddhaMenu() {
    }
}
