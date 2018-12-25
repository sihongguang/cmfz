package com.baizhi.facade;

import com.baizhi.entity.Album;

import javax.servlet.http.HttpServletRequest;

public interface AlbumFacade{
    void AlbumDeleteFile(Album album, HttpServletRequest request);
    void addCount(String id);
}
