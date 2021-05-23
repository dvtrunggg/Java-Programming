package com.myclass.service.impl;

import java.util.List;

import com.myclass.dao.HoaDonStatusDao;
import com.myclass.entity.HoaDonStatus;
import com.myclass.service.HoaDonStatusService;

public class HoaDonStatusServiceImpl implements HoaDonStatusService {

    private HoaDonStatusDao hoaDonStatusDao;

    public HoaDonStatusServiceImpl() {
        hoaDonStatusDao = new HoaDonStatusDao();
    }

    public List<HoaDonStatus> getAll() {
        return hoaDonStatusDao.getAll();
    }

    public HoaDonStatus getById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    public int insert(HoaDonStatus dto) {
        // TODO Auto-generated method stub
        return 1;

    }

    @Override
    public int update(HoaDonStatus dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
