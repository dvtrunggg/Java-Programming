package com.myclass.dao;
import java.sql.SQLException;

import com.myclass.conn.JDBCConnection;
import com.myclass.entity.DonGia;

public class DonGiaDao extends ObjDao {

	public DonGia getDonGia() {
		try {
			connection = JDBCConnection.getConnection();
			String query = "SELECT * FROM dongia";
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				DonGia entity = new DonGia();
				entity.setGiaDien(resultSet.getInt("giaDien"));
				entity.setGiaNuoc(resultSet.getInt("giaNuoc"));

				return entity;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDatabaseResources();
		}

		return null;
	}

	public int updateGiaDien(int giaDien) {
		try {
			connection = JDBCConnection.getConnection();
			String query = "UPDATE dongia SET giaDien = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(1, giaDien);

			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDatabaseResources();
		}

		return 0;
	}

	public int updateGiaNuoc(int giaNuoc) {
		try {
			connection = JDBCConnection.getConnection();
			String query = "UPDATE dongia SET giaNuoc = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(1, giaNuoc);

			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDatabaseResources();
		}

		return 0;
	}

}
