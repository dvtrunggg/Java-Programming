/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.controller;

import com.group5.view.PhongTroJPanel;
import com.group5.view.khachThueJPanel;
import com.group5.view.HomeJPanel;
import com.group5.view.hoaDonJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author trung
 */
public class ChuyenManHinhController {

    private JPanel root;
    private String kindSelected = "";
    private ArrayList<DanhMuc> listItem;

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "Home";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new HomeJPanel());
        root.validate();
        root.repaint();
    }
    
     public void setViewHome(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        //jpnItem.setBackground(new Color(96, 100, 191));
        //jlbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new HomeJPanel());
        root.validate();
        root.repaint();
    }

    public void setEvent(ArrayList<DanhMuc> listItem) {
        this.listItem = listItem;
        for (DanhMuc i : listItem) {
            i.getJlb().addMouseListener(new LabelEvent(i.getKind(), i.getJpn(), i.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new HomeJPanel();
                    break;
                case "KhachHang":
                    node = new khachThueJPanel();
                    break;

                case "PhongTro":
                    node = new PhongTroJPanel();
                    break;

                case "HoaDon":
                    node = new hoaDonJPanel();
                    break;
                // more
                default:
                    node = new HomeJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(76, 175, 80));
                jlbItem.setBackground(new Color(76, 175, 80));
            }
        }

        public void setChangBackground(String kind) {
            for (DanhMuc i : listItem) {
                if (i.getKind().equalsIgnoreCase(kind)) {
                    i.getJpn().setBackground(new Color(94, 100, 191));
                    i.getJlb().setBackground(new Color(94, 100, 191));

                } else {
                    i.getJpn().setBackground(new Color(76, 175, 80));
                    i.getJlb().setBackground(new Color(76, 175, 80));

                }
            }
        }

    }

}
