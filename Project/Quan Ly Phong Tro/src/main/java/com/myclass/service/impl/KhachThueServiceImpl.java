package com.myclass.service.impl;

import java.util.List;

import com.myclass.dao.KhachThueDao;
import com.myclass.dao.PhongTroDao;
import com.myclass.dto.KhachThueDto;
import com.myclass.dto.PhongTroDto;
import com.myclass.entity.KhachThue;
import com.myclass.service.KhachThueService;

public class KhachThueServiceImpl implements KhachThueService {
    
    private KhachThueDao khachThueDao;
    private PhongTroDao phongTroDao; 
    
    public KhachThueServiceImpl() {
        khachThueDao = new KhachThueDao();
        phongTroDao = new PhongTroDao(); 
    }

    public List<KhachThueDto> getAll() {
   
        return khachThueDao.getAll();
    }

    public KhachThueDto getById(Integer id) {
        return khachThueDao.getById(id);
    }

    public int insert(KhachThueDto dto) {
        // TODO Auto-generated method stub
        KhachThue khachThue = new KhachThue();
        
        khachThue.setId(dto.getId());
        khachThue.setHoTen(dto.getHoTen());
        khachThue.setSoDienThoai(dto.getSoDienThoai());
        khachThue.setEmail(dto.getEmail());
        khachThue.setGioiTinh(dto.getGioiTinh());
        khachThue.setNgaySinh(dto.getNgaySinh());
        khachThue.setCmnd(dto.getCmnd());
        khachThue.setHinhAnh(dto.getHinhAnh());
        khachThue.setPhuongTien(dto.getPhuongTien());
        khachThue.setHoKhau(dto.getHoKhau());
        
        for(PhongTroDto phong: phongTroDao.getAll()){
            if(phong.getTenPhong().equals(dto.getTenPhong())){
                  khachThue.setMaPhong(phong.getId());
                  break; 
            }
        }
        
        return khachThueDao.add(khachThue);
    }

    public int update(KhachThueDto dto) {
        KhachThue khachThue = new KhachThue();
        
        khachThue.setId(dto.getId());
        khachThue.setHoTen(dto.getHoTen());
        khachThue.setSoDienThoai(dto.getSoDienThoai());
        khachThue.setEmail(dto.getEmail());
        khachThue.setGioiTinh(dto.getGioiTinh());
        khachThue.setNgaySinh(dto.getNgaySinh());
        khachThue.setCmnd(dto.getCmnd());
        khachThue.setHinhAnh(dto.getHinhAnh());
        khachThue.setPhuongTien(dto.getPhuongTien());
        khachThue.setHoKhau(dto.getHoKhau());
        
        for(PhongTroDto phong: phongTroDao.getAll()){
            if(phong.getTenPhong().equals(dto.getTenPhong())){
                  khachThue.setMaPhong(phong.getId());
                  break; 
            }
        }
        
        return khachThueDao.update(khachThue);

    }

    public int delete(Integer id) {
        // TODO Auto-generated method stub
        return khachThueDao.delete(id);
    }

}
