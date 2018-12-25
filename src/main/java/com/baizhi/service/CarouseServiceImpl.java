package com.baizhi.service;

import com.baizhi.dao.CarouseDAO;
import com.baizhi.entity.Carouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CarouseServiceImpl implements CarouseService{
    @Autowired
    private CarouseDAO carouseDAO;

    @Override
    public void UpdateForName(Carouse carouse) {
        carouseDAO.updateCarouse(carouse);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Carouse> queryall(){
        List<Carouse> queryall = carouseDAO.queryall();
        return queryall;
    }

    @Override
    public void addCarouse(Carouse carouse, String path,String name) {
        carouse.setCarouseid(UUID.randomUUID().toString());
        carouse.setCreatename(name);
        carouse.setStatus("Y");
        carouse.setImgpath(path);
        carouseDAO.insert(carouse);
    }

    @Override
    public void upDateStatus(Carouse carouse) {
        carouse.setStatus("N");
        carouseDAO.updateCarouse(carouse);
    }



    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Carouse queryByID(String str) {
        return carouseDAO.queryByStr(str);
    }
}
