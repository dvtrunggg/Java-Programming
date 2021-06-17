package com.myclass.service.impl;

import com.myclass.dao.PhongStatusDao;
import java.util.List;

import com.myclass.entity.PhongStatus;
import com.myclass.service.PhongStatusService;

public class PhongTroStatusServiceImpl implements PhongStatusService {

    private PhongStatusDao phongStatusDao = new PhongStatusDao();

    public PhongTroStatusServiceImpl() {
        phongStatusDao = new PhongStatusDao();
    }

    public List<PhongStatus> getAll() {
       return phongStatusDao.getAll();
    }

    public PhongStatus getById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    public int insert(PhongStatus dto) {
        // TODO Auto-generated method stub
        return 1;
    }

    public int update(PhongStatus dto) {
        // TODO Auto-generated method stub
        return 1;

    }

    public int delete(Integer id) {
        // TODO Auto-generated method stub
        return 1;
    }

}
