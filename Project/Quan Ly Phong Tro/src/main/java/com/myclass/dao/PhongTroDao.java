package com.myclass.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.myclass.conn.JDBCConnection;
import com.myclass.dto.PhongTroDto;
import com.myclass.entity.PhongTro;

public class PhongTroDao extends ObjDao{
	
	public List<PhongTroDto> getAll(){
		List<PhongTroDto> entities = new LinkedList<PhongTroDto>(); 
		
		try {
			connection = JDBCConnection.getConnection();
			String query = "SELECT * FROM PhongTro as p JOIN PhongStatus as ps ON p.status = ps.id";

			statement = connection.prepareStatement(query);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				PhongTroDto entity = new PhongTroDto();
				entity.setId(resultSet.getInt("id"));
				entity.setTenPhong(resultSet.getString("tenPhong"));
				entity.setDienTich(resultSet.getInt("dienTich"));
				entity.setMoTa(resultSet.getString("moTa"));
				entity.setGiaPhong(resultSet.getInt("giaPhong"));
				entity.setStatusName(resultSet.getString("ps.name"));

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
	
	public PhongTroDto getById(int id) {
		try {
			connection = JDBCConnection.getConnection();
			String query = "SELECT * FROM PhongTro as p JOIN PhongStatus as ps ON p.status = ps.id WHERE p.id = ?";
			
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				PhongTroDto entity = new PhongTroDto();
				entity.setId(resultSet.getInt("id"));
				entity.setTenPhong(resultSet.getString("tenPhong"));
				entity.setDienTich(resultSet.getInt("dienTich"));
				entity.setMoTa(resultSet.getString("moTa"));
				entity.setGiaPhong(resultSet.getInt("giaPhong"));
				entity.setStatusName(resultSet.getString("ps.name"));
				
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
	
	public int add(PhongTro phongTro) {
		try {
			connection = JDBCConnection.getConnection();
			String query = "INSERT INTO PhongTro(tenPhong, dienTich, moTa, giaPhong, status) VALUES (?,?,?,?,?)";
			
			statement = connection.prepareStatement(query);
			statement.setString(1, phongTro.getTenPhong());
			statement.setInt(2, phongTro.getDienTich());		
			statement.setString(3, phongTro.getMoTa());
			statement.setInt(4, phongTro.getGiaPhong());
			statement.setInt(5, phongTro.getStatus());
			
			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			closeDatabaseResources();
		}

		return 0;
	}
		
	public int update(PhongTro phongTro) {
		try {
			connection = JDBCConnection.getConnection();
			String query = "UPDATE PhongTro SET tenPhong = ?, dienTich = ?, moTa = ?, giaPhong = ?, status = ? WHERE id = ?";
			
			statement = connection.prepareStatement(query);
			statement = connection.prepareStatement(query);
			statement.setString(1, phongTro.getTenPhong());
			statement.setInt(2, phongTro.getDienTich());		
			statement.setString(3, phongTro.getMoTa());
			statement.setInt(4, phongTro.getGiaPhong());
			statement.setInt(5, phongTro.getStatus());
			statement.setInt(6, phongTro.getId());
			
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
		String query =  "DELETE FROM PhongTro WHERE id = ?";
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
