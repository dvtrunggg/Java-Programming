/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.service.impl;

import java.util.List;

import com.group5.dao.HoaDonStatusDao;
import com.group5.entity.HoaDonStatus;
import com.group5.service.HoaDonStatusService;

public class HoaDonStatusServiceImpl implements HoaDonStatusService {
	private HoaDonStatusDao hoaDonStatusDao ; 
	
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

	public void insert(HoaDonStatus dto) {
		// TODO Auto-generated method stub
		
	}

	public void update(HoaDonStatus dto) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}


}
