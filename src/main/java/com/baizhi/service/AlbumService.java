package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    //展示专辑
    List<Album> queryAll(Integer page,Integer rows);
    //添加专辑
    void addAlbum(Album album,String path,String name);
    //删除专辑
    void delete(Album album);
    //根据id查询
    Album queryByid(Album album);
    //查询所有条
    Integer queryCountAlbum();
    //查询文章条数
    Integer queryCount(String id);
    //修改文件的集数
    void updateAlbum(Album album);
}
