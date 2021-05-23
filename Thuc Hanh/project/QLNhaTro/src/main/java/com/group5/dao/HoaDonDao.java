/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.group5.conn.JDBCConnection;
import com.group5.dto.HoaDonDto;
import com.group5.dto.KhachThueDto;
import com.group5.entity.HoaDon;
import com.group5.entity.KhachThue;

public class HoaDonDao extends ObjDao {	
	PhongTroDao phongTroDao = new PhongTroDao();
	
	public List<HoaDonDto> getAll(){
		List<HoaDonDto> entities = new LinkedList<HoaDonDto>(); 
		
		try {
			connection = JDBCConnection.getConnection();
			String query = "SELECT * FROM hoadon as h JOIN hoadonstatus as hs ON h.status = hs.id";

			statement = connection.prepareStatement(query);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				HoaDonDto entity = new HoaDonDto();
				entity.setId(resultSet.getInt("id"));
				entity.setTenPhong(phongTroDao.getById(resultSet.getInt("maPhong")).getTenPhong());
				entity.setStartDate(resultSet.getDate("startdate"));
				entity.setEndDate(resultSet.getDate("endDate"));
				entity.setGiaDien(resultSet.getInt("giaDien"));
				entity.setGiaNuoc(resultSet.getInt("giaNuoc"));
				entity.setSoDien(resultSet.getInt("soDien"));
				entity.setSoNuoc(resultSet.getInt("soNuoc"));
				entity.setGiaPhong(resultSet.getInt("giaPhong"));
				entity.setTienPhong(resultSet.getInt("tienPhong"));
				entity.setStatusName(resultSet.getString("hs.name"));
				
				entities.add(entity);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			closeDatabaseResources();
		}

		return entities;
	}
	
	public HoaDonDto getById(int id) {
		try {
			connection = JDBCConnection.getConnection();
			String query = "SELECT * FROM hoadon as h JOIN hoadonstatus as hs ON h.status = hs.id WHERE h.id = ?";
			
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				HoaDonDto entity = new HoaDonDto();
				entity.setId(resultSet.getInt("id"));
				entity.setTenPhong(phongTroDao.getById(resultSet.getInt("maPhong")).getTenPhong());
				entity.setStartDate(resultSet.getDate("startdate"));
				entity.setEndDate(resultSet.getDate("endDate"));
				entity.setGiaDien(resultSet.getInt("giaDien"));
				entity.setGiaNuoc(resultSet.getInt("giaNuoc"));
				entity.setSoDien(resultSet.getInt("soDien"));
				entity.setSoNuoc(resultSet.getInt("soNuoc"));
				entity.setGiaPhong(resultSet.getInt("giaPhong"));
				entity.setTienPhong(resultSet.getInt("tienPhong"));
				entity.setStatusName(resultSet.getString("hs.name"));
				
				return entity;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			closeDatabaseResources();
		}

		return null;
	}	
	
	public int add(HoaDon hoaDon) {
		try {
			connection = JDBCConnection.getConnection();
			String query = "INSERT INTO HoaHDon(maPhong,startDate,endDate,giaDien,giaNuoc,soDien,soNuoc,giaPhong,tienPhong,status)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			statement = connection.prepareStatement(query);
			statement.setInt(1, hoaDon.getMaPhong());
			statement.setDate(2, hoaDon.getStartDate());
			statement.setDate(3, hoaDon.getEndDate());
			statement.setInt(4, hoaDon.getGiaDien());
			statement.setInt(5, hoaDon.getGiaNuoc());
			statement.setInt(6, hoaDon.getSoDien());
			statement.setInt(7, hoaDon.getSoNuoc());
			statement.setInt(8, hoaDon.getGiaPhong());
			statement.setInt(9, hoaDon.getTienPhong());
			statement.setInt(10, hoaDon.getStatus());
			
			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			closeDatabaseResources();
		}

		return 0;
	}
		
	public int update(HoaDon hoaDon) {
		try {
			connection = JDBCConnection.getConnection();
			String query = "UPDATE HoaDon SET maPhong = ? , startDate = ?, endDate = ?, giaDien = ?, "
					+ "giaNuoc = ?, soDien = ?, soNuoc = ? , giaPhong = ?, tienPhong = ?, status = ? WHERE id = ?";
			
			statement = connection.prepareStatement(query);
			statement.setInt(1, hoaDon.getMaPhong());
			statement.setDate(2, hoaDon.getStartDate());
			statement.setDate(3, hoaDon.getEndDate());
			statement.setInt(4, hoaDon.getGiaDien());
			statement.setInt(5, hoaDon.getGiaNuoc());
			statement.setInt(6, hoaDon.getSoDien());
			statement.setInt(7, hoaDon.getSoNuoc());
			statement.setInt(8, hoaDon.getGiaPhong());
			statement.setInt(9, hoaDon.getTienPhong());
			statement.setInt(10, hoaDon.getStatus());
			statement.setInt(11, hoaDon.getId());
			
			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			closeDatabaseResources();
		}

		return 0;
	}
	
	public int delete(int id) {
		String query =  "DELETE FROM HoaDon WHERE id = ?";
		try{
			connection = JDBCConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query); 
			statement.setInt(1, id);
			
			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			closeDatabaseResources();
		}
		return 0; 
	}

}
