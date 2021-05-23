/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.controller;

import com.group5.dao.KhachThueDao;
import com.group5.dto.KhachThueDto;
import com.group5.entity.KhachThue;
import com.group5.view.KhachThueJFrame;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author trung
 */
public class KhachThueController {

    private JButton btnSubmit;
    private JTextField jtfID;
    private JTextField jtfHoTen;
    private JTextField jtfSoDienThoai;
    private JTextField jtfCMND;
    private JTextField jtfEmail;
    private JRadioButton jrbNam;
    private JRadioButton jrbNu;
    private JDateChooser jdcNgaySinh;
    private JTextField jtfPhong;
    private JLabel jlbMsg;

    private KhachThue kt;
    private KhachThueDao ktDao;

    public KhachThueController(JButton btnSubmit, JTextField jtfID, JTextField jtfHoTen) {
        this.btnSubmit = btnSubmit;
        this.jtfID = jtfID;
        this.jtfHoTen = jtfHoTen;
    }

    public KhachThueController(JButton btnSubmit, JTextField jtfID, JTextField jtfHoTen,
            JTextField jtfSoDienThoai, JTextField jtfCMND, JTextField jtfEmail,
            JRadioButton jrbNam, JRadioButton jrbNu, JDateChooser jdcNgaySinh,
            JTextField jtfPhong, JLabel jlbMsg) {

        this.btnSubmit = btnSubmit;
        this.jtfID = jtfID;
        this.jtfHoTen = jtfHoTen;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtfCMND = jtfCMND;
        this.jtfEmail = jtfEmail;
        this.jrbNam = jrbNam;
        this.jrbNu = jrbNu;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jtfPhong = jtfPhong;
        this.jlbMsg = jlbMsg;
        //this.kt = kt;

        this.ktDao = new KhachThueDao();
    }

    public void setView(KhachThue kt) {
        this.kt = kt;
        jtfID.setText(Integer.toString(kt.getId()));
        jtfHoTen.setText(kt.getHoTen());
        jtfSoDienThoai.setText(kt.getSoDienThoai());
        jtfEmail.setText(kt.getEmail());
        jtfCMND.setText(kt.getCmnd());
        jtfPhong.setText(Integer.toString(kt.getMaPhong()));

        try {
            if (kt.getGioiTinh().equals("Nu")) {
                jrbNam.setSelected(false);
                jrbNu.setSelected(true);

            } else {
                jrbNam.setSelected(true);
                jrbNu.setSelected(false);
            }

        } catch (NullPointerException e) {
            jrbNam.setSelected(true);
        }

        jdcNgaySinh.setDate(kt.getNgaySinh());

    }

    public void setEvent() {

        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfHoTen.getText().length() == 0) {
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                } else {
                    kt.setHoTen(jtfHoTen.getText());
                    
                    java.sql.Date sd = new java.sql.Date(jdcNgaySinh.getDate().getTime());
                    kt.setNgaySinh(sd);

                    kt.setSoDienThoai(jtfSoDienThoai.getText());
                    kt.setEmail(jtfEmail.getText());
                    kt.setMaPhong(Integer.parseInt(jtfPhong.getText()));
                    kt.setCmnd(jtfCMND.getText());
                    if (jrbNam.isSelected()) {
                        kt.setGioiTinh("Nam");
                    } else {
                        kt.setGioiTinh("Nu");
                    }

                    int check = ktDao.add(kt);
                    if (check != 0) {
                        jlbMsg.setText("Thành Công");
                    }

//                    int check2 = ktDao.update(kt);
//                    if (check2 != 0) {
//                        jlbMsg.setText("Thành Công");
//                    }

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
        });
    }




}
