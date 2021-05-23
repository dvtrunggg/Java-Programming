/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.service.impl;

import java.util.List;

import com.group5.dao.KhachThueDao;
import com.group5.dto.KhachThueDto;
import com.group5.entity.KhachThue;
import com.group5.service.KhachThueService;

public class KhachThueServiceImpl implements KhachThueService {
	
	private KhachThueDao khachThueDao; 
	
	public KhachThueServiceImpl() {
		khachThueDao = new KhachThueDao(); 
	}
	
	public List<KhachThueDto> getAll() {
		return khachThueDao.getAll();
	}

	public KhachThueDto getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(KhachThueDto dto) {
		// TODO Auto-generated method stub
		
	}

	public void update(KhachThueDto dto) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}


	
	
}
