/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.group5.conn.JDBCConnection;
import com.group5.dto.HoaDonDto;
import com.group5.entity.HoaDonStatus;

public class HoaDonStatusDao extends ObjDao{
	
	public List<HoaDonStatus> getAll(){
		List<HoaDonStatus> entities = new LinkedList<HoaDonStatus>(); 
		
		try {
			connection = JDBCConnection.getConnection();
			String query = "SELECT * FROM hoadonstatus";

			statement = connection.prepareStatement(query);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				HoaDonStatus entity = new HoaDonStatus();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				
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
	
	public HoaDonStatus getByName(String name){
		try {
			connection = JDBCConnection.getConnection();
			String query = "SELECT * FROM HoaDonStatus WHERE name = ? ";
			
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				HoaDonStatus entity = new HoaDonStatus();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));
				 
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
}
