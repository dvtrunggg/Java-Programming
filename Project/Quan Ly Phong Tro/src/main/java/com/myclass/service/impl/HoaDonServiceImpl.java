package com.myclass.service.impl;

import java.util.List;

import com.myclass.dao.HoaDonDao;
import com.myclass.dao.HoaDonStatusDao;
import com.myclass.dao.PhongTroDao;
import com.myclass.dto.HoaDonDto;
import com.myclass.dto.PhongTroDto;
import com.myclass.entity.HoaDon;
import com.myclass.service.HoaDonService;

public class HoaDonServiceImpl implements HoaDonService {

    private HoaDonDao hoaDonDao;
    private HoaDonStatusDao hoaDonStatusDao;
    private PhongTroDao phongTroDao;

    public HoaDonServiceImpl() {
        hoaDonDao = new HoaDonDao();
        hoaDonStatusDao = new HoaDonStatusDao();
        phongTroDao = new PhongTroDao();
    }

    public List<HoaDonDto> getAll() {
        return hoaDonDao.getAll();
    }

    public HoaDonDto getById(Integer id) {
        return hoaDonDao.getById(id);
    }

    public int insert(HoaDonDto dto) {
        HoaDon entity = new HoaDon();
        entity.setId(dto.getId());
        for (PhongTroDto phong : phongTroDao.getAll()) {
            if (phong.getTenPhong().equals(dto.getTenPhong())) {
                entity.setMaPhong(phong.getId());
                break;
            }
        }
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setGiaDien(dto.getGiaDien());
        entity.setGiaNuoc(dto.getGiaNuoc());
        entity.setSoDien(dto.getSoDien());
        entity.setSoNuoc(dto.getSoNuoc());
        entity.setGiaPhong(dto.getGiaPhong());
        entity.setTienPhong(dto.getTienPhong());
        entity.setStatus(hoaDonStatusDao.getByName(dto.getStatusName()).getId());

        return hoaDonDao.add(entity);
    }

    public int update(HoaDonDto dto) {
        HoaDon entity = new HoaDon();
        entity.setId(dto.getId());

        for (PhongTroDto phong : phongTroDao.getAll()) {
            if (phong.getTenPhong().equals(dto.getTenPhong())) {
                entity.setMaPhong(phong.getId());
                break;
            }
        }

        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setGiaDien(dto.getGiaDien());
        entity.setGiaNuoc(dto.getGiaNuoc());
        entity.setSoDien(dto.getSoDien());
        entity.setSoNuoc(dto.getSoNuoc());
        entity.setGiaPhong(dto.getGiaPhong());
        entity.setTienPhong(dto.getTienPhong());
        entity.setStatus(hoaDonStatusDao.getByName(dto.getStatusName()).getId());

        return hoaDonDao.update(entity);

    }

    public int delete(Integer id) {
        return hoaDonDao.delete(id);
    }
}
