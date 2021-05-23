
package com.group5.service.impl;
import java.util.List;

import com.group5.dao.HoaDonDao;
import com.group5.dao.HoaDonStatusDao;
import com.group5.dto.HoaDonDto;
import com.group5.entity.HoaDon;
import com.group5.service.HoaDonService;

public class HoaDonServiceImpl implements HoaDonService{

	private HoaDonDao hoaDonDao; 
	private HoaDonStatusDao hoaDonStatusDao; 
	
	public HoaDonServiceImpl() {
		hoaDonDao = new HoaDonDao();
		hoaDonStatusDao = new HoaDonStatusDao();
	}

	public List<HoaDonDto> getAll() {
		return hoaDonDao.getAll(); 
	}

	public HoaDonDto getById(Integer id) {
		return hoaDonDao.getById(id); 
	}

	public void insert(HoaDonDto dto) {
		HoaDon entity = new HoaDon(); 
		entity.setId(dto.getId());
		entity.setStartDate(dto.getStartDate());
		entity.setEndDate(dto.getEndDate());
		entity.setGiaDien(dto.getGiaDien());
		entity.setGiaNuoc(dto.getGiaNuoc());
		entity.setSoDien(dto.getSoDien());
		entity.setSoNuoc(dto.getSoNuoc());
		entity.setGiaPhong(dto.getGiaPhong());
		entity.setTienPhong(dto.getTienPhong());
		entity.setStatus(hoaDonStatusDao.getByName(dto.getStatusName()).getId());
		
		hoaDonDao.add(entity);
	}

	public void update(HoaDonDto dto) {
		HoaDon entity = new HoaDon(); 
		entity.setId(dto.getId());
		entity.setStartDate(dto.getStartDate());
		entity.setEndDate(dto.getEndDate());
		entity.setGiaDien(dto.getGiaDien());
		entity.setGiaNuoc(dto.getGiaNuoc());
		entity.setSoDien(dto.getSoDien());
		entity.setSoNuoc(dto.getSoNuoc());
		entity.setGiaPhong(dto.getGiaPhong());
		entity.setTienPhong(dto.getTienPhong());
		entity.setStatus(hoaDonStatusDao.getByName(dto.getStatusName()).getId());
		
		hoaDonDao.update(entity);
	}

	public void delete(Integer id) {
		hoaDonDao.delete(id); 
	}
}
