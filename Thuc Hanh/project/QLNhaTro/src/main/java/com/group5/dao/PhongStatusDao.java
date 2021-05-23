
package com.group5.dao;

import com.group5.conn.JDBCConnection;
import com.group5.entity.PhongStatus;

import java.sql.SQLException;
import java.util.LinkedList;

public class PhongStatusDao extends ObjDao {

	public LinkedList<PhongStatus> getAll() {
		LinkedList<PhongStatus> entities = new LinkedList<PhongStatus>();

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