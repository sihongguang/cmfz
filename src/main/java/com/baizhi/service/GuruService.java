package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    //展示
    List<Guru> queryallGuruAndArticle();
    //添加
    void addGuru(Guru guru,String name,String path);
    //修改
    void updateGuru(Guru guru);
    //展示
    List<Guru> queryallGuru();
}
