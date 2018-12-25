package com.baizhi.service;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    private AlbumDAO albumDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Album> queryAll(Integer page,Integer rows) {
        Integer countPage=(page-1)*rows;//得到的是从第几个开始显示  rows 是显示多少个
        return albumDAO.queryAlbumPage(countPage,rows);
    }

    @Override
    public void addAlbum(Album album,String path,String name) {
        album.setCover(path+"/"+name);
        albumDAO.insert(album);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Album queryByid(Album album){
        Album album1 = albumDAO.queryByStr(album.getId());
        return album1;
    }


    @Transactional (propagation = Propagation.SUPPORTS)
    @Override
    public Integer queryCountAlbum() {
        Integer integer = albumDAO.queryConutAlbum();
        return integer;
    }

    @Override
    public void delete(Album album) {
        albumDAO.delete(album);
    }

    @Override
    public void updateAlbum(Album album) {
        albumDAO.updateAlbum(album);
    }

    @Transactional (propagation =Propagation.SUPPORTS)
    @Override
    public Integer queryCount(String id) {
        Integer queryCount = albumDAO.queryCount(id);
        return queryCount;
    }
}
