package com.myclass.controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.myclass.dto.KhachThueDto;
import com.myclass.service.impl.KhachThueServiceImpl;
import com.myclass.views.KhachThueJFrame;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class QuanLyKhachThue {

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private KhachThueServiceImpl khachThueServiceImpl;

    private final String[] COLUMNS = {"ID", "Họ tên", "Ngày sinh", "Giới tính", "Email",
        "Số điện thọai", "Tên phòng"};

    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyKhachThue(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;

        khachThueServiceImpl = new KhachThueServiceImpl();

    }

    public void setDataToTable() {
        List<KhachThueDto> listItems = khachThueServiceImpl.getAll();
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
                    KhachThueJFrame frame = new KhachThueJFrame(null);
                    frame.setLocationRelativeTo(null);
                    frame.setTitle("Thêm khách thuê");
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
                        KhachThueDto khachThue = khachThueServiceImpl.getById(id);
                        
                        KhachThueJFrame frame = new KhachThueJFrame(khachThue);
                        frame.setLocationRelativeTo(null);
                        frame.setTitle("Thông tin khách thuê");
                        frame.setVisible(true);
                    } catch (ParseException ex) {
                        Logger.getLogger(QuanLyKhachThue.class.getName()).log(Level.SEVERE, null, ex);
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

    public DefaultTableModel setTableModel(List<KhachThueDto> listItems, String[] listColumn) {
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
                KhachThueDto khachThueDto = listItems.get(i);
                obj = new Object[columns];
                obj[0] = khachThueDto.getId();
                obj[1] = khachThueDto.getHoTen();
                obj[2] = khachThueDto.getNgaySinh();;
                obj[3] = khachThueDto.getGioiTinh();
                obj[4] = khachThueDto.getEmail();
                obj[5] = khachThueDto.getSoDienThoai();
                obj[6] = khachThueDto.getTenPhong();
                dtm.addRow(obj);
            }
        }

        return dtm;
    }
}
