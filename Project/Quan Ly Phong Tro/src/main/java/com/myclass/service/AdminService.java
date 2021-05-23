package com.myclass.service;

import com.myclass.entity.Admin;

public interface AdminService {
	Admin checkLoginAdmin(String taiKhoan, String matKhau);
	
	int changePassword(int id, String matKhau); 
}
