/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.controller;

/**
 *
 * @author trung
 */
import com.group5.dto.KhachThueDto;
import com.group5.service.impl.KhachThueServiceImpl;
import java.util.Iterator;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView.TableRow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class QuanLyKhachThue {

    private JPanel jpnView;
    private JTextField jtfSearch;

    private KhachThueServiceImpl khachThueServiceImpl = new KhachThueServiceImpl();

    private String[] COLUMN = {"ID_Khach", "Họ Tên", "Giới Tính", "Số Điện Thoại", "CMND", "ID_Phòng"};
    private TableRow<TableModel> rowSorter = null;

    public void setDataToTable() {
        List<KhachThueDto> listItem = khachThueServiceImpl.getAll();

        DefaultTableModel model = new ClassTableModel().setTableKhachThue(listItem, COLUMN);
        JTable table = new JTable(model);
       // row
       
       
       
    }
}

class ClassTableModel {

    public DefaultTableModel setTableKhachThue(List<KhachThueDto> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCellEditTable(int row, int column) {
                return false;
            }
        };

        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();

        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                KhachThueDto kt = listItem.get(i);
                obj = new Object[columns];
                obj[0] = kt.getId();
                obj[1] = kt.getHoTen();
                obj[2] = kt.getGioiTinh();
                obj[3] = kt.getSoDienThoai();
                obj[4] = kt.getCmnd();
                obj[5] = kt.getTenPhong();

                dtm.addRow(obj);

            }
        }
        return dtm;
    }
}
