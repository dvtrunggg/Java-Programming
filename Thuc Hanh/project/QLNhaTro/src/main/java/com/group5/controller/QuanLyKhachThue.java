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
import com.group5.entity.KhachThue;
import com.group5.service.impl.KhachThueServiceImpl;
import com.group5.view.KhachThueJFrame;
import java.util.Iterator;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
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

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class QuanLyKhachThue {

    private JPanel jpnView;
    private JTextField jtfSearch;
    private JButton btnAdd;
    private KhachThueServiceImpl khachThueServiceImpl = new KhachThueServiceImpl();

    private String[] COLUMN = {"ID_Khach", "Họ Tên", "Giới Tính", "Ngày Sinh", "Số Điện Thoại", "CMND", "Phòng", "Email"};
    

    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyKhachThue(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;

    }

    public void setDataToTable() {
        List<KhachThueDto> listItem = khachThueServiceImpl.getAll();
       

        DefaultTableModel model = new ClassTableModel().setTableKhachThue(listItem, COLUMN);
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    int selectedRowIndex = table.getSelectedRow();

                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

                    KhachThue khachThue = new KhachThue();
                    khachThue.setId((int) model.getValueAt(selectedRowIndex, 0));
                    khachThue.setHoTen(model.getValueAt(selectedRowIndex, 1).toString());
                    khachThue.setGioiTinh(model.getValueAt(selectedRowIndex, 2).toString());

                    khachThue.setNgaySinh((Date) model.getValueAt(selectedRowIndex, 3));
                    khachThue.setSoDienThoai(model.getValueAt(selectedRowIndex, 4).toString());

                    khachThue.setCmnd(model.getValueAt(selectedRowIndex, 5).toString());

                    khachThue.setMaPhong((int) model.getValueAt(selectedRowIndex, 6));
                    khachThue.setEmail(model.getValueAt(selectedRowIndex, 7).toString());

                    KhachThueJFrame frame = new KhachThueJFrame(khachThue);
                    frame.setTitle("Thông Tin Khách Thuê");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

                }
            }
        });

        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));

        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();

    }

    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KhachThue kt = new KhachThue();
                KhachThueJFrame frame = new KhachThueJFrame(kt);
                frame.setTitle("Thông Tin Khách Thuê");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);

                frame.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100, 221, 23));
            }
        });
    }
}

class ClassTableModel {

    public DefaultTableModel setTableKhachThue(List<KhachThueDto> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCellEditTable(int row, int column) {
                return false;
            }

            public Class<?> getColumnClass(int col) {
                return col == 8 ? Boolean.class : String.class;
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
                obj[3] = kt.getNgaySinh();
                obj[4] = kt.getSoDienThoai();
                obj[5] = kt.getCmnd();
                //obj[6] = kt.getMaPhong();
                obj[7] = kt.getEmail();

                dtm.addRow(obj);

            }
        }
        return dtm;
    }

}
