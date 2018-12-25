package com.baizhi.service;

import com.baizhi.dao.BuddhaMenuDAO;
import com.baizhi.entity.BuddhaMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BuddhaMenuServiceImpl implements BuddhaMenuService{
    @Autowired
    private BuddhaMenuDAO buddhaMenuDAO;

    public List<BuddhaMenu> queryallBuddhaMenu(){
        return buddhaMenuDAO.queryall();
    }
}
