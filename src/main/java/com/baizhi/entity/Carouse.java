package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/*
* 轮播图
* */
public class Carouse {
    private  String carouseid;//轮播图id
    private  String carousetitle;//轮播图名字
    private  String imgpath;//轮播图片路径
    private  String status;//状态
    @JSONField(format="yyyy/MM/dd")
    private  Date createtime;//添加时间
    private  String description;//简介内容
    private  String createname;//添加者
    private  String href;//路径
    private String ex1;
    private String ex2;
    private String ex3;
    private String ex4;
    private String ex5;

    public Carouse(String carouseid, String carousetitle, String imgpath, String status, Date createtime, String description, String createname, String href, String ex1, String ex2, String ex3, String ex4, String ex5) {
        this.carouseid = carouseid;
        this.carousetitle = carousetitle;
        this.imgpath = imgpath;
        this.status = status;
        this.createtime = createtime;
        this.description = description;
        this.createname = createname;
        this.href = href;
        this.ex1 = ex1;
        this.ex2 = ex2;
        this.ex3 = ex3;
        this.ex4 = ex4;
        this.ex5 = ex5;
    }

    @Override
    public String toString() {
        return "Carouse{" +
                "carouseid='" + carouseid + '\'' +
                ", carousetitle='" + carousetitle + '\'' +
                ", imgpath='" + imgpath + '\'' +
                ", status='" + status + '\'' +
                ", createtime=" + createtime +
                ", description='" + description + '\'' +
                ", createname='" + createname + '\'' +
                ", href='" + href + '\'' +
                ", ex1='" + ex1 + '\'' +
                ", ex2='" + ex2 + '\'' +
                ", ex3='" + ex3 + '\'' +
                ", ex4='" + ex4 + '\'' +
                ", ex5='" + ex5 + '\'' +
                '}';
    }

    public String getCarouseid() {
        return carouseid;
    }

    public void setCarouseid(String carouseid) {
        this.carouseid = carouseid;
    }

    public String getCarousetitle() {
        return carousetitle;
    }

    public void setCarousetitle(String carousetitle) {
        this.carousetitle = carousetitle;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getEx1() {
        return ex1;
    }

    public void setEx1(String ex1) {
        this.ex1 = ex1;
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

    public Carouse() {
    }

}
