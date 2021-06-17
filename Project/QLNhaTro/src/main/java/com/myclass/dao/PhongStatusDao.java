package com.myclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.myclass.conn.JDBCConnection;
import com.myclass.entity.PhongStatus;

public class PhongStatusDao extends ObjDao {

	public List<PhongStatus> getAll() {
		List<PhongStatus> entities = new LinkedList<PhongStatus>();

		try {
			connection = JDBCConnection.getConnection();
			String query = "SELECT * FROM phongstatus";

			statement = connection.prepareStatement(query);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				PhongStatus entity = new PhongStatus();
				entity.setId(resultSet.getInt("id"));
				entity.setName(resultSet.getString("name"));

				entities.add(entity);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDatabaseResources();
		}

		return entities;
	}

}
