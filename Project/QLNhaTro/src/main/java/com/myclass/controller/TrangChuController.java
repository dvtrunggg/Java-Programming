/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myclass.controller;

import com.myclass.dto.HoaDonDto;
import com.myclass.service.KhachThueService;
import com.myclass.service.impl.HoaDonServiceImpl;
import com.myclass.service.impl.KhachThueServiceImpl;
import com.myclass.service.impl.PhongTroServiceImpl;
import javax.swing.JLabel;

/**
 *
 * @author hoang
 */
public class TrangChuController {

    private JLabel jlbKhachThue;
    private JLabel jlbPhongTro;
    private JLabel jlbDoanhThu;

    private KhachThueServiceImpl khachThueService;
    private PhongTroServiceImpl phongTroService;
    private HoaDonServiceImpl hoaDonService;

    public TrangChuController(JLabel jlbKhachThue, JLabel jlbPhongTro, JLabel jlbDoanhThu) {
        this.jlbKhachThue = jlbKhachThue;
        this.jlbPhongTro = jlbPhongTro;
        this.jlbDoanhThu = jlbDoanhThu;

        khachThueService = new KhachThueServiceImpl();
        phongTroService = new PhongTroServiceImpl();
        hoaDonService = new HoaDonServiceImpl();
    }

    public void setData() {
        int slKhach = khachThueService.getAll().size();
        int slPhong = phongTroService.getAll().size();
        int doanhThu = 0;
        for (HoaDonDto hd : hoaDonService.getAll()) {
            doanhThu = doanhThu + hd.getTienPhong();
        }

        jlbKhachThue.setText(String.valueOf(slKhach));
        jlbPhongTro.setText(String.valueOf(slPhong));
        jlbDoanhThu.setText(String.valueOf(doanhThu));

    }
}
