/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.dto;
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
