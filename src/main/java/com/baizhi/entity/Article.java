package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 文章实体类
 * */
public class Article {
    private  String articleid;//文章id
    private  String articlename;//文章名字articlename guruname
    private  String createname;//创建者
    @JSONField(format="yyyy/MM/dd")
    private  Date publishtime;//发布时间
    private  String figurepath;//文章路径
    private  String content;//文章内容
    private  String guruid;//大师id
    private  String guruname;//创作者姓名
    public Article() {
    }


    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getArticlename() {
        return articlename;
    }

    public void setArticlename(String articlename) {
        this.articlename = articlename;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getFigurepath() {
        return figurepath;
    }

    public void setFigurepath(String figurepath) {
        this.figurepath = figurepath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Article(String articleid, String articlename, String createname, Date publishtime, String figurepath, String content, String guruid, String guruname) {
        this.articleid = articleid;
        this.articlename = articlename;
        this.createname = createname;
        this.publishtime = publishtime;
        this.figurepath = figurepath;
        this.content = content;
        this.guruid = guruid;
        this.guruname = guruname;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleid='" + articleid + '\'' +
                ", articlename='" + articlename + '\'' +
                ", createname='" + createname + '\'' +
                ", publishtime=" + publishtime +
                ", figurepath='" + figurepath + '\'' +
                ", content='" + content + '\'' +
                ", guruid='" + guruid + '\'' +
                ", guruname='" + guruname + '\'' +
                '}';
    }
}
