package com.baizhi.dao;

import java.util.List;
/**
 * @author  shg
 * */
public interface BaseDAO<T>{
    //查询
    List<T> queryall();
    //添加
    void insert(T t);
    //删除
    void delete(T t);
    //根据字符串查询
    T queryByStr(String str);
}
