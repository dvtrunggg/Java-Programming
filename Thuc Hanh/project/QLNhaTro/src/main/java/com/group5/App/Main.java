/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.App;
import com.group5.entity.*;

import com.group5.dao.KhachThueDao;
import com.group5.dao.HoaDonStatusDao;
import com.group5.dao.PhongStatusDao;


import com.group5.dto.KhachThueDto;
import com.group5.dto.*;

import com.group5.view.MainJFrame;
import java.sql.Date;
import java.util.LinkedList;
import javax.swing.SwingUtilities;

/**
 *
 * @author trung
 */
public class Main {

    public static void main(String[] args) {
        
        
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });

        
       
        
        
        
        
        
        
        
        
//        KhachThueDao khachThueDao = new KhachThueDao();
//        LinkedList<KhachThueDto> danhSachKhachThue = khachThueDao.getAll();
//
//        for (KhachThueDto khach : danhSachKhachThue) {
//            System.out.println(khach.toString());
//        }

    }

//        public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            new MainJFrame().setVisible(true);
//        });
//    }
}
