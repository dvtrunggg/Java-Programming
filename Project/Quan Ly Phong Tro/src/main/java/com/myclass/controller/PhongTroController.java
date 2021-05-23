package com.myclass.controller;

import com.myclass.dto.KhachThueDto;
import com.myclass.dto.PhongTroDto;
import com.myclass.entity.PhongStatus;
import com.myclass.service.impl.KhachThueServiceImpl;
import com.myclass.service.impl.PhongTroServiceImpl;
import com.myclass.service.impl.PhongTroStatusServiceImpl;
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

public class PhongTroController {

    private String action;
    private JButton btnDelete;
    private JButton btnSubmit;
    
    private JTextField jtfTenPhong;
    private JTextField jtfGiaTien;   
    private JTextField jtfDienTich;  
    private JTextArea jtaMota;
    private JComboBox jcbTinhTrang;
    private JLabel jlbMsg;

    private PhongTroDto phongTro;

    private PhongTroServiceImpl phongTroService;
    private PhongTroStatusServiceImpl phongStatusService;

    public PhongTroController(String action, JButton btnDelete, JButton btnSubmit, JTextField jtfTenPhong, JTextField jtfGiaTien, JTextField jtfDienTich, JTextArea jtaMota, JComboBox jcbTinhTrang, JLabel jlbMsg) {
        this.action = action;
        this.btnDelete = btnDelete;
        this.btnSubmit = btnSubmit;
        this.jtfTenPhong = jtfTenPhong;
        this.jtfGiaTien = jtfGiaTien;
        this.jtfDienTich = jtfDienTich;
        this.jtaMota = jtaMota;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;
        
        phongTro = new PhongTroDto();
        phongTroService = new PhongTroServiceImpl();
        phongStatusService = new PhongTroStatusServiceImpl();
    }

    public void setView(PhongTroDto phongTro) throws ParseException {

        int indexOfStatus = 0;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List<PhongStatus> dsStatus = phongStatusService.getAll();
        for (PhongStatus status : dsStatus) {
            model.addElement(status.getName());
        }
        jcbTinhTrang.setModel(model);

        if (action.equals("update")) {
            this.phongTro = phongTro;
            // set data
            jtfTenPhong.setText(phongTro.getTenPhong());
            jtfDienTich.setText(String.valueOf(phongTro.getDienTich()));
            jtfGiaTien.setText(String.valueOf(phongTro.getGiaPhong()));
            jtaMota.setText(phongTro.getMoTa());

            for (PhongStatus status : dsStatus) {
                if (phongTro.getStatusName().equals(status.getName())) {
                    indexOfStatus = dsStatus.indexOf(status);
                    break;
                }
            }
            jcbTinhTrang.setSelectedIndex(indexOfStatus);
        }

        if (action.equals("insert")) {
            btnDelete.setVisible(false);
            jcbTinhTrang.setSelectedIndex(indexOfStatus);
        }

        // set event
        setEvent();
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                phongTro.setTenPhong(jtfTenPhong.getText().trim());
                phongTro.setDienTich(Integer.valueOf(jtfDienTich.getText().trim()));
                phongTro.setGiaPhong(Integer.valueOf(jtfGiaTien.getText().trim()));
                phongTro.setMoTa(jtaMota.getText().trim());
                phongTro.setStatusName((String) jcbTinhTrang.getItemAt(jcbTinhTrang.getSelectedIndex()));

                int lastId;
                if (showDialog("Bạn có muốn lưu dữ liệu không ? ")) {
                    switch (action) {
                        case "update":
                            lastId = phongTroService.update(phongTro);
                            if (lastId != 0) {
                                jlbMsg.setText("Cập nhật dữ liệu thành công!");

                            } else {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            }
                            break;
                        case "insert":
                            lastId = phongTroService.insert(phongTro);
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
                    int lastId = phongTroService.delete(phongTro.getId());
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
}
