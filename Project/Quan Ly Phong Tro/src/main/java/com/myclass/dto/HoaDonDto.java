package com.myclass.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class HoaDonDto {
	private int id;
	private String tenPhong;
	private Date startDate;
	private Date endDate;
	private int giaDien;
	private int giaNuoc;
	private int soDien;
	private int soNuoc;
	private int giaPhong;
	private int tienPhong; 
	private String statusName;
}
