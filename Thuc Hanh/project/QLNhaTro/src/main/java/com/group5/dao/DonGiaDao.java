/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.dao;

import com.group5.conn.JDBCConnection;
import com.group5.entity.DonGia;
import java.sql.SQLException;


/**
 *
 * @author trung
 */
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