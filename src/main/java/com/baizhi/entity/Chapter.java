package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

/*
*章节实体类
* */
public class Chapter {
    private  String id;//章节id
    private  String title;//章节name
    private  String size;//章节大小
    private  String duration;//播放时长
    private  String downpath;//下载路径
    @JSONField(format="yyyy/MM/dd")
    private  Date uploaddate;//上传时间
    private  String albumid;//父类id
    private  String albumtitle;//专辑名称
    public Chapter() {
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", duration='" + duration + '\'' +
                ", downpath='" + downpath + '\'' +
                ", uploaddate=" + uploaddate +
                ", albumid='" + albumid + '\'' +
                ", albumtitle='" + albumtitle + '\'' +
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDownpath() {
        return downpath;
    }

    public void setDownpath(String downpath) {
        this.downpath = downpath;
    }

    public Date getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(Date uploaddate) {
        this.uploaddate = uploaddate;
    }

    public String getAlbumid() {
        return albumid;
    }

    public void setAlbumid(String albumid) {
        this.albumid = albumid;
    }

    public String getAlbumtitle() {
        return albumtitle;
    }

    public void setAlbumtitle(String albumtitle) {
        this.albumtitle = albumtitle;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return Objects.equals(id, chapter.id) &&
                Objects.equals(title, chapter.title) &&
                Objects.equals(size, chapter.size) &&
                Objects.equals(duration, chapter.duration) &&
                Objects.equals(downpath, chapter.downpath) &&
                Objects.equals(uploaddate, chapter.uploaddate) &&
                Objects.equals(albumid, chapter.albumid) &&
                Objects.equals(albumtitle, chapter.albumtitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, size, duration, downpath, uploaddate, albumid, albumtitle);
    }

    public Chapter(String id, String title, String size, String duration, String downpath, Date uploaddate, String albumid, String albumtitle) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.duration = duration;
        this.downpath = downpath;
        this.uploaddate = uploaddate;
        this.albumid = albumid;
        this.albumtitle = albumtitle;
    }
}
