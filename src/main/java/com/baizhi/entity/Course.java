package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/*
* 功课表
* */
public class Course {
    private  String courseid;//功课id
    private  String coursetitle;//功课名字
    private  String marking;//标识
    private  String coursestatus;//功课状态
    private  String userid;//用户id
    @JSONField(format="yyyy/MM/dd")
    private  Date cretetime;//创建时间

    public Course() {
    }
}
