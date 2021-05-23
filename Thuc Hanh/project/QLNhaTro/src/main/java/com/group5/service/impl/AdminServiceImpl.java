/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.service.impl;
import com.group5.dao.AdminDao;
import com.group5.entity.Admin;
import com.group5.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;
	
	public AdminServiceImpl() {
		adminDao = new AdminDao(); 
	}
	
	public Admin checkLoginAdmin(String taiKhoan, String matKhau) {
		Admin admin = adminDao.findByAccount(taiKhoan);
		if(admin != null && admin.getMatKhau().equals(matKhau)) {
			return admin;
		}
		return null;
	}


	public int changePassword(int id, String matKhau) {
		return adminDao.changePassword(id, matKhau);
	}
	
	
}
