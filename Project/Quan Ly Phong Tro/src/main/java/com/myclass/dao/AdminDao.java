package com.myclass.dao;

import java.sql.SQLException;

import com.myclass.conn.JDBCConnection;
import com.myclass.entity.Admin;

public class AdminDao extends ObjDao {
	
	public Admin findByAccount(String account) {
		try {
			connection = JDBCConnection.getConnection();
			String query = "SELECT * FROM admin WHERE taiKhoan = ?";
			
			statement = connection.prepareStatement(query);
			statement.setString(1, account);
			
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Admin entity = new Admin(); 
				entity.setId(resultSet.getInt("id"));
				entity.setTaiKhoan(resultSet.getString("taiKhoan"));
				entity.setMatKhau(resultSet.getString("matKhau"));
				
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
	
	// CHANGE PASSWORD OF USER 
		public int changePassword(int id, String matKhau) {
			String query = "UPDATE admin SET matKhau = ? WHERE id = ?";
			try{
				connection = JDBCConnection.getConnection();
				statement = connection.prepareStatement(query); 
				
				statement.setString(1,matKhau);
				statement.setInt(2, id);
				
				return statement.executeUpdate();
				
			}  catch (SQLException e) {
				e.printStackTrace();
			} 
			finally {
				closeDatabaseResources();
			}
			return 0; 
		}
}
