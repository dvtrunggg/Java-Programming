package com.myclass.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class KhachThueDto {
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
	private String tenPhong;

}
