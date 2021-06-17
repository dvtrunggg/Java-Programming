package com.myclass.controller;

import com.myclass.dto.KhachThueDto;
import com.myclass.dto.PhongTroDto;
import com.myclass.service.impl.KhachThueServiceImpl;
import com.myclass.service.impl.PhongTroServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KhachThueController {

    private String action;

    private JButton btnDelete;
    private JButton btnSubmit;
    private JTextField jtfHoTen;
    private JTextField jtfEmail;
    private JTextField jtfSoDienThoai;
    private JDateChooser jdcNgaySinh;
    private JRadioButton jrdGioiTinhNam;
    private JRadioButton jrdGioiTinhNu;
    private JTextArea jtaHoKhau;
    private JTextField jtfCmnd;
    private JTextField jtfPhuongTien;
    private JComboBox jcbTenPhong;
    private JLabel jlbMsg;

    private KhachThueDto khachThue;

    private KhachThueServiceImpl khachThueService;
    private PhongTroServiceImpl phongTroService;

    public KhachThueController(String action, JButton btnDelete, JButton btnSubmit, JTextField jtfHoTen, JTextField jtfEmail, JTextField jtfSoDienThoai, JDateChooser jdcNgaySinh, JRadioButton jrdGioiTinhNam, JRadioButton jrdGioiTinhNu, JTextArea jtaHoKhau, JTextField jtfCmnd, JTextField jtfPhuongTien, JComboBox jcbTenPhong, JLabel jlbMsg) {
        this.action = action;
        this.btnDelete = btnDelete;
        this.btnSubmit = btnSubmit;
        this.jtfHoTen = jtfHoTen;
        this.jtfEmail = jtfEmail;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jrdGioiTinhNam = jrdGioiTinhNam;
        this.jrdGioiTinhNu = jrdGioiTinhNu;
        this.jtaHoKhau = jtaHoKhau;
        this.jtfCmnd = jtfCmnd;
        this.jtfPhuongTien = jtfPhuongTien;
        this.jcbTenPhong = jcbTenPhong;
        this.jlbMsg = jlbMsg;

        khachThue = new KhachThueDto();
        khachThueService = new KhachThueServiceImpl();
        phongTroService = new PhongTroServiceImpl();
    }

    public void setView(KhachThueDto khachThue) throws ParseException {

        int indexOfPhong = 0;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List<PhongTroDto> dsPhong = phongTroService.getAll();
        for (PhongTroDto phong : dsPhong) {
            model.addElement(phong.getTenPhong());
        }
        jcbTenPhong.setModel(model);

        if (action.equals("update")) {
            this.khachThue = khachThue;
            // set data
            jtfHoTen.setText(khachThue.getHoTen());
            jtfEmail.setText(khachThue.getEmail());
            jtfSoDienThoai.setText(khachThue.getSoDienThoai());
            jtfCmnd.setText(khachThue.getCmnd());
            jtfPhuongTien.setText(khachThue.getPhuongTien());
            jtaHoKhau.setText(khachThue.getHoKhau());
            jdcNgaySinh.setDate(new Date(khachThue.getNgaySinh().getTime()));
            if (khachThue.getGioiTinh().equalsIgnoreCase("Nam")) {
                jrdGioiTinhNam.setSelected(true);
            } else {
                jrdGioiTinhNu.setSelected(true);
            }

            for (PhongTroDto phong : dsPhong) {
                if (khachThue.getTenPhong().equals(phong.getTenPhong())) {
                    indexOfPhong = dsPhong.indexOf(phong);
                    break;
                }
            }
            jcbTenPhong.setSelectedIndex(indexOfPhong);
        }

        if (action.equals("insert")) {
            btnDelete.setVisible(false);
            this.khachThue = new KhachThueDto();
            jcbTenPhong.setSelectedIndex(indexOfPhong);
//            Date date = new Date();
//            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//            date = ft.parse("2021-05-19");
//            System.out.println(date);
        }

        java.sql.Date ngSinh = new java.sql.Date(0, 0, 0);
        this.khachThue.setNgaySinh(ngSinh);

        // set event
        setEvent();
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                khachThue.setHoTen(jtfHoTen.getText().trim());
                khachThue.setEmail(jtfEmail.getText().trim());
                khachThue.setSoDienThoai(jtfSoDienThoai.getText().trim());
                khachThue.setCmnd(jtfCmnd.getText().trim());
                khachThue.setPhuongTien(jtfPhuongTien.getText().trim());
                khachThue.setHinhAnh("");
                khachThue.setHoKhau(jtaHoKhau.getText().trim());
                if (jrdGioiTinhNam.isSelected()) {
                    khachThue.setGioiTinh("Nam");
                } else {
                    khachThue.setGioiTinh("Nữ");
                }

                if (jdcNgaySinh.getDate() != null) {
                    khachThue.setNgaySinh(covertDateToDateSql(jdcNgaySinh.getDate()));
                }

                khachThue.setTenPhong((String) jcbTenPhong.getItemAt(jcbTenPhong.getSelectedIndex()));

                int lastId;
                if (showDialog("Bạn có muốn lưu dữ liệu không ? ")) {
                    switch (action) {
                        case "update":
                            lastId = khachThueService.update(khachThue);
                            if (lastId != 0) {
                                jlbMsg.setText("Cập nhật dữ liệu thành công!");

                            } else {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            }
                            break;
                        case "insert":
                            lastId = khachThueService.insert(khachThue);
                            if (lastId != 0) {
                                jlbMsg.setText("Thêm dữ liệu thành công!");

                            } else {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            }
                            break;
                        default:
                            break;
                    }
                }

            }

        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showDialog("Bạn có muốn xóa dữ liệu không ?")) {
                    int lastId = khachThueService.delete(khachThue.getId());
                    if (lastId != 0) {
                        jlbMsg.setText("Xóa dữ liệu thành công!");

                    } else {
                        jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                    }
                }
            }
        });
    }

    private boolean showDialog(String act) {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                act, "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }

    public java.sql.Date covertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
}
