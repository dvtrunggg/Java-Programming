/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.dto;

import java.sql.Date;

import lombok.Data;


@Data
public class PhongTroDto {
	private int id;
	private String tenPhong;
	private int dienTich;
	private String moTa;
	private int giaPhong;
	private String statusName;
}