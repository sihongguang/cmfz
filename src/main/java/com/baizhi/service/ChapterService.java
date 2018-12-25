package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService {

    //添加章节
    void addChapter(Chapter chapter);
    //id查询
    Chapter queryByid(String id);
    //删除章节
    void deleteChapter(Chapter chapter);
    //查询所有Pid 对应的章节
    List<Chapter> queryAllByPid(String pid);
}
