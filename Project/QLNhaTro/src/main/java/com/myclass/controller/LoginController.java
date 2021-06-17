package com.myclass.controller;

import com.myclass.entity.Admin;
import com.myclass.service.impl.AdminServiceImpl;
import com.myclass.views.MainJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginController {

    private JButton btnLogin;
    private JTextField jtfTaiKhoan;
    private JTextField jtfMatKhau;
    private JLabel jlbMesg;
    private JFrame frame;

    private AdminServiceImpl adminServiceImpl;

    public LoginController(JButton btnLogin, JTextField jtfTaiKhoan, JTextField jtfMatKhau, JLabel jlbMesg, JFrame frame) {
        this.btnLogin = btnLogin;
        this.jtfTaiKhoan = jtfTaiKhoan;
        this.jtfMatKhau = jtfMatKhau;
        this.jlbMesg = jlbMesg;
        this.frame  = frame;
        
        adminServiceImpl = new AdminServiceImpl();
    }

    public void login() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taiKhoan = jtfTaiKhoan.getText();
                String matKhau = jtfMatKhau.getText();

                Admin admin = adminServiceImpl.checkLoginAdmin(taiKhoan, matKhau);
                if (admin == null) {
                    jlbMesg.setText("Tài khoản hoặc mật khẩu không đúng !");
                }
                else{
                    frame.setVisible(false);
                    new MainJFrame().setVisible(true);
                }
            }
        });
    }
}
