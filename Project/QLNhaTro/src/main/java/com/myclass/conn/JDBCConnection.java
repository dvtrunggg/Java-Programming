package com.myclass.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.myclass.constants.DBConstants;

public class JDBCConnection {
	
	public static Connection getConnection() {
		try {
			Class.forName(DBConstants.DRIVER);
			Connection conn = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("Not found Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Wrong infomation connect Database !");
			e.printStackTrace();
		}
		
		return null;
	}
}
