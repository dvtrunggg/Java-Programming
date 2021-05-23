/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.entity;

import java.sql.Date;


import lombok.Data;


@Data
public class KhachThue {

    private int id;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private String gioiTinh;
    private Date ngaySinh;
    private String cmnd;
    private String hinhAnh;
    private String phuongTien;
    private String hoKhau;
    private int maPhong;


}
