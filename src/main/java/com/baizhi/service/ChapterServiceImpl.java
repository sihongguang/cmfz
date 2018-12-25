package com.baizhi.service;

import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService{

    @Autowired
    private ChapterDAO chapterDAO;

    @Override
    public void addChapter(Chapter chapter) {

        chapterDAO.insert(chapter);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Chapter queryByid(String id) {
        Chapter chapter = chapterDAO.queryByStr(id);

        return chapter;
    }
    @Override
    public void deleteChapter(Chapter chapter) {
        chapterDAO.delete(chapter);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Chapter> queryAllByPid(String pid) {
        List<Chapter> queryByPidAll = chapterDAO.queryByPidAll(pid);
        return queryByPidAll;
    }
}
