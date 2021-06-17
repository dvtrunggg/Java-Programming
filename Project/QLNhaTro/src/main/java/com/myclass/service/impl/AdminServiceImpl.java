package com.myclass.service.impl;

import com.myclass.dao.AdminDao;
import com.myclass.entity.Admin;
import com.myclass.service.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao;

    public AdminServiceImpl() {
        adminDao = new AdminDao();
    }

    public Admin checkLoginAdmin(String taiKhoan, String matKhau) {
        Admin admin = adminDao.findByAccount(taiKhoan);
        if (admin != null && admin.getMatKhau().equals(matKhau)) {
            return admin;
        }
        return null;
    }

    public int changePassword(int id, String matKhau) {
        return adminDao.changePassword(id, matKhau);
    }

}
