/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.service;

/**
 *
 * @author trung
 */

import com.group5.entity.Admin;

public interface AdminService {
	Admin checkLoginAdmin(String taiKhoan, String matKhau);
	
	int changePassword(int id, String matKhau); 
}
