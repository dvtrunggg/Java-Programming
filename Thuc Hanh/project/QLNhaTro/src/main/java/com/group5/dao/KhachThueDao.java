/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.dao;

import com.group5.conn.JDBCConnection;
import com.group5.dto.KhachThueDto;
import com.group5.entity.KhachThue;
import java.sql.SQLException;
import java.util.LinkedList;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachThueDao extends ObjDao {

    public static int soLuongKhachThue;

    public void countKT() {
        try {
            connection = JDBCConnection.getConnection();
            String queryCount = "SELECT count(*) as total FROM qlnhatro.phongtro";
            Statement stmt = connection.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(KhachThueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LinkedList<KhachThueDto> getAll() {
        LinkedList<KhachThueDto> entities = new LinkedList<KhachThueDto>();

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
        } finally {
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
        } finally {
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
        } finally {
            closeDatabaseResources();
        }

        return 0;
    }
    
    
    
    

    public int add(KhachThueDto khachThue) {
        try {
            connection = JDBCConnection.getConnection();
            String query = "INSERT INTO khachthue(hoTen,soDienThoai,email,gioiTinh,ngaySinh,cmnd, maPhong) VALUES (?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(query);
            //statement.setInt(1, khachThue.getId());

            statement.setString(1, khachThue.getHoTen());
            statement.setString(2, khachThue.getSoDienThoai());
            statement.setString(3, khachThue.getEmail());
            statement.setString(4, khachThue.getGioiTinh());
            statement.setDate(5, khachThue.getNgaySinh());
            statement.setString(6, khachThue.getCmnd());   
            statement.setInt(7, khachThue.getMaPhong());

            return statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        } finally {
            closeDatabaseResources();
        }

        return 0;
    }

    public int delete(int id) {
        String query = "DELETE FROM khachthue WHERE id = ?";
        try {
            connection = JDBCConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            return statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDatabaseResources();
        }
        return 0;
    }
}
