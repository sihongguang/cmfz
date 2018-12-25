package com.baizhi.service;

import com.baizhi.dao.GuruDAO;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements GuruService{
    @Autowired
    private GuruDAO guruDAO;


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override//表连接查询大师查询
    public List<Guru> queryallGuruAndArticle() {
        List<Guru> queryall = guruDAO.queryall();
        return queryall;
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override//单个大师查询
    public List<Guru> queryallGuru() {
        List<Guru> queryall = guruDAO.queryAllGuru();
        return queryall;
    }

    @Override
    public void addGuru(Guru guru,String path,String name ) {
        guru.setGuruid(UUID.randomUUID().toString());
        guru.setGurustatus("Y");
        guru.setProfile(path);
        guru.setCreatename(name);
        guruDAO.insert(guru);
    }

    @Override
    public void updateGuru(Guru guru) {
        guruDAO.updateGuru(guru);
    }
}
