package com.myclass.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.myclass.conn.JDBCConnection;
import com.myclass.dto.KhachThueDto;
import com.myclass.entity.KhachThue;

public class KhachThueDao extends ObjDao {
	
	public List<KhachThueDto> getAll(){
		List<KhachThueDto> entities = new LinkedList<KhachThueDto>(); 
		
		try {
			connection = JDBCConnection.getConnection();
			String query = "SELECT * FROM khachthue as k JOIN phongtro as p ON k.maPhong = p.id";

			statement = connection.prepareStatement(query);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				KhachThueDto entity = new KhachThueDto();
				entity.setId(resultSet.getInt("id"));
				entity.setHoTen(resultSet.getString("hoTen"));
				entity.setSoDienThoai(resultSet.getString("soDienThoai"));
				entity.setEmail(resultSet.getString("email"));
				entity.setGioiTinh(resultSet.getString("gioiTinh"));
				entity.setNgaySinh(resultSet.getDate("ngaySinh"));
				entity.setCmnd(resultSet.getString("cmnd"));	
				entity.setPhuongTien(resultSet.getString("phuongTien"));
				entity.setHoKhau(resultSet.getString("hoKhau"));
				entity.setTenPhong(resultSet.getString("p.tenPhong"));

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
	
	public KhachThueDto getById(int id) {
		try {
			connection = JDBCConnection.getConnection();
			String query = "SELECT * FROM khachthue as k JOIN phongtro as p ON k.maPhong = p.id WHERE k.id = ?";
			
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				KhachThueDto entity = new KhachThueDto();
				entity.setId(resultSet.getInt("id"));
				entity.setHoTen(resultSet.getString("hoTen"));
				entity.setSoDienThoai(resultSet.getString("soDienThoai"));
				entity.setEmail(resultSet.getString("email"));
				entity.setGioiTinh(resultSet.getString("gioiTinh"));
				entity.setNgaySinh(resultSet.getDate("ngaySinh"));
				entity.setCmnd(resultSet.getString("cmnd"));	
				entity.setPhuongTien(resultSet.getString("phuongTien"));
				entity.setHoKhau(resultSet.getString("hoKhau"));
				entity.setTenPhong(resultSet.getString("p.tenPhong"));
				
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
	
	public int add(KhachThue khachThue) {
		try {
			connection = JDBCConnection.getConnection();
			String query = "INSERT INTO khachthue(hoTen,soDienThoai,email,gioiTinh,ngaySinh,cmnd,hinhAnh,"
					+ "phuongTien,hoKhau,maPhong) VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			statement = connection.prepareStatement(query);
			statement.setString(1, khachThue.getHoTen());
			statement.setString(2, khachThue.getSoDienThoai());
			statement.setString(3, khachThue.getEmail());
			statement.setString(4, khachThue.getGioiTinh());
			statement.setDate(5, khachThue.getNgaySinh());
			statement.setString(6, khachThue.getCmnd());	
			statement.setString(7, khachThue.getHinhAnh());
			statement.setString(8, khachThue.getPhuongTien());
			statement.setString(9, khachThue.getHoKhau());
			statement.setInt(10, khachThue.getMaPhong());
			
			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			closeDatabaseResources();
		}

		return 0;
	}
		
	public int update(KhachThue khachThue) {
		try {
			connection = JDBCConnection.getConnection();
			String query = "UPDATE khachthue SET hoTen = ? , soDienThoai = ?, email = ?, gioiTinh = ?, "
					+ "ngaySinh = ?, cmnd = ?, hinhAnh = ? , phuongTien = ?, hoKhau = ?, maPhong = ? WHERE id = ?";
			
			statement = connection.prepareStatement(query);
			statement.setString(1, khachThue.getHoTen());
			statement.setString(2, khachThue.getSoDienThoai());
			statement.setString(3, khachThue.getEmail());
			statement.setString(4, khachThue.getGioiTinh());
			statement.setDate(5, khachThue.getNgaySinh());
			statement.setString(6, khachThue.getCmnd());	
			statement.setString(7, khachThue.getHinhAnh());
			statement.setString(8, khachThue.getPhuongTien());
			statement.setString(9, khachThue.getHoKhau());
			statement.setInt(10, khachThue.getMaPhong());
			statement.setInt(11, khachThue.getId());
			
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
		String query =  "DELETE FROM khachthue WHERE id = ?";
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
