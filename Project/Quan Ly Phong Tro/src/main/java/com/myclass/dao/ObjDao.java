package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ObjDao {
	
	protected Connection connection;
	protected ResultSet resultSet;
	protected PreparedStatement statement;
	
	protected void closeDatabaseResources() {
		try {
			// close resultset--> statement --> connectoion
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
