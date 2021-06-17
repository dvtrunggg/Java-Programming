/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myclass.controller;

import com.myclass.dto.PhongTroDto;
import com.myclass.dto.PhongTroDto;
import com.myclass.service.impl.KhachThueServiceImpl;
import com.myclass.service.impl.PhongTroServiceImpl;
import com.myclass.views.KhachThueJFrame;
import com.myclass.views.PhongTroJFrame;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 *
 * @author hoang
 */
public class QuanLyPhongTro {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private PhongTroServiceImpl phongTroServiceImpl;

    private final String[] COLUMNS = {"ID", "Tên phòng", "Diện tích(m2)", "Mô tả", "Giá Phòng",
        "Tình trạng"};

    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyPhongTro(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;

        phongTroServiceImpl = new PhongTroServiceImpl();

    }

    public void setDataToTable() {
        List<PhongTroDto> listItems = phongTroServiceImpl.getAll();
        DefaultTableModel model = setTableModel(listItems, COLUMNS);
        final JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        // tim kiem 
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

        // them moi 
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PhongTroJFrame frame = new PhongTroJFrame(null);
                    frame.setLocationRelativeTo(null);
                    frame.setTitle("Thêm phòng");
                    frame.setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(QuanLyKhachThue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // update 
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    try {
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        int selectedRowIndex = table.getSelectedRow();
                        selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                        int id = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
                        PhongTroDto phongTro = phongTroServiceImpl.getById(id);
                        
                        PhongTroJFrame frame = new PhongTroJFrame(phongTro);
                        frame.setLocationRelativeTo(null);
                        frame.setTitle("Thông tin phòng");
                        frame.setVisible(true);
                    } catch (ParseException ex) {
                        Logger.getLogger(QuanLyPhongTro.class.getName()).log(Level.SEVERE, null, ex);
                    }
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

        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();

    }

    public DefaultTableModel setTableModel(List<PhongTroDto> listItems, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        ;
        };
	
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItems.size();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                PhongTroDto phongTroDto = listItems.get(i);
                obj = new Object[columns];
                obj[0] = phongTroDto.getId();
                obj[1] = phongTroDto.getTenPhong();
                obj[2] = phongTroDto.getDienTich();;
                obj[3] = phongTroDto.getMoTa();
                obj[4] = phongTroDto.getGiaPhong();
                obj[5] = phongTroDto.getStatusName();
                dtm.addRow(obj);
            }
        }

        return dtm;
    }
}
