package com.myclass.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class HoaDon {
	private int id;
	private int maPhong;
	private Date startDate;
	private Date endDate;
	private int giaDien;
	private int giaNuoc;
	private int soDien;
	private int soNuoc;
	private int giaPhong;
	private int tienPhong; 
	private int status;
}
