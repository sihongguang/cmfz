package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDAO  extends BaseDAO<Album>{
    List<Album> queryAlbumPage(@Param("page")Integer page,@Param("rows") Integer rows);

    Integer queryConutAlbum();

    Integer queryCount(String id);

    void  updateAlbum(Album album);
}
