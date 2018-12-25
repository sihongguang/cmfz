package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 计数的实体类
 * */
public class Counter {
    private String counterid;//计数id
    private String userid;//用户类id
    private String courseid;//功课类id
    private  String countnumber;//计数
    private  String name;//计数名称
    @JSONField(format="yyyy/MM/dd")
    private  String createtime;//创建的时间

    @Override
    public String toString() {
        return "Counter{" +
                "counterid='" + counterid + '\'' +
                ", userid='" + userid + '\'' +
                ", courseid='" + courseid + '\'' +
                ", countnumber='" + countnumber + '\'' +
                ", name='" + name + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }

    public String getCounterid() {
        return counterid;
    }

    public void setCounterid(String counterid) {
        this.counterid = counterid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCountnumber() {
        return countnumber;
    }

    public void setCountnumber(String countnumber) {
        this.countnumber = countnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Counter(String counterid, String userid, String courseid, String countnumber, String name, String createtime) {
        this.counterid = counterid;
        this.userid = userid;
        this.courseid = courseid;
        this.countnumber = countnumber;
        this.name = name;
        this.createtime = createtime;
    }

    public Counter() {
    }
}
