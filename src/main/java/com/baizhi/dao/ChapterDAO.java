package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterDAO extends BaseDAO<Chapter>{

    //查询
    List<Chapter> queryByPidAll(@Param("pid") String pid);
}
