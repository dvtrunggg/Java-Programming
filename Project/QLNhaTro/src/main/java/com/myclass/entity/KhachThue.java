package com.myclass.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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

    public KhachThue() {
    }

}
