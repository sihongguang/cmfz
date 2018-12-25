package com.baizhi.service;

import com.baizhi.entity.Carouse;

import java.util.List;

public interface CarouseService {
    //展示
    List<Carouse> queryall();
    //添加
    void addCarouse(Carouse carouse,String path,String name);
    //删除更新
    void upDateStatus(Carouse carouse);
    //修改前展示(id查询)
    Carouse queryByID(String str);
    //删除更新
    void UpdateForName(Carouse carouse);
}
