package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/*
* 专辑实体类
* */
public class Album {
    private  String id;//专辑id
    private  String title;//专辑名称
    private  String author;//作者
    private  String cover;//封面
    private  String count;//集数
    private  String broadcast;//播音
    private  String score;//评分
    @JSONField(format="yyyy/MM/dd")
    private  Date publisdate;//发布时间
    private  String brief;//简介
    private  String createname;//创建者
    private  List<Chapter> children;//章节集合

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", count='" + count + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", score='" + score + '\'' +
                ", publisdate=" + publisdate +
                ", brief='" + brief + '\'' +
                ", createname='" + createname + '\'' +
                ", children=" + children +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getPublisdate() {
        return publisdate;
    }

    public void setPublisdate(Date publisdate) {
        this.publisdate = publisdate;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public Album(String id, String title, String author, String cover, String count, String broadcast, String score, Date publisdate, String brief, String createname, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.cover = cover;
        this.count = count;
        this.broadcast = broadcast;
        this.score = score;
        this.publisdate = publisdate;
        this.brief = brief;
        this.createname = createname;
        this.children = children;
    }

    public Album() {
    }
}
