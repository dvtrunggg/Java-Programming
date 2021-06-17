package com.myclass.service.impl;

import com.myclass.dao.PhongStatusDao;
import com.myclass.dao.PhongTroDao;
import com.myclass.dto.PhongTroDto;
import com.myclass.entity.PhongStatus;
import com.myclass.entity.PhongTro;
import java.util.List;

import com.myclass.service.PhongTroService;

public class PhongTroServiceImpl implements PhongTroService {

    private PhongTroDao phongTroDao;
    private PhongStatusDao phongStatusDao;

    public PhongTroServiceImpl() {
        phongTroDao = new PhongTroDao();
        phongStatusDao = new PhongStatusDao();
    }

    @Override
    public List<PhongTroDto> getAll() {
        return phongTroDao.getAll();
    }

    @Override
    public PhongTroDto getById(Integer id) {
        return phongTroDao.getById(id);
    }

    @Override
    public int insert(PhongTroDto dto) {
        PhongTro phongTro = new PhongTro();
        phongTro.setId(dto.getId());
        phongTro.setTenPhong(dto.getTenPhong());
        phongTro.setGiaPhong(dto.getGiaPhong());
        phongTro.setMoTa(dto.getMoTa());
        phongTro.setDienTich(dto.getDienTich());
        for (PhongStatus status : phongStatusDao.getAll()) {
            if (status.getName().equals(dto.getStatusName())) {
                phongTro.setStatus(status.getId());
                break;
            }
        }

        return phongTroDao.add(phongTro);
    }

    @Override
    public int update(PhongTroDto dto) {
        PhongTro phongTro = new PhongTro();
        phongTro.setId(dto.getId());
        phongTro.setTenPhong(dto.getTenPhong());
        phongTro.setGiaPhong(dto.getGiaPhong());
        phongTro.setMoTa(dto.getMoTa());
        phongTro.setDienTich(dto.getDienTich());
        for (PhongStatus status : phongStatusDao.getAll()) {
            if (status.getName().equals(dto.getStatusName())) {
                phongTro.setStatus(status.getId());
                break;
            }
        }

        return phongTroDao.update(phongTro);
    }

    @Override
    public int delete(Integer id) {
        return phongTroDao.delete(id);
    }

}
