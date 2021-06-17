package com.myclass.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.myclass.bean.DanhMuc;
import com.myclass.views.HoaDonJPanel;
import com.myclass.views.KhachThueJPanel;
import com.myclass.views.PhongTroJPanel;
import com.myclass.views.TrangChuJPanel;

public class ChuyenManHinhController {

    private JPanel root;
    private String kindSelected = "";
    private ArrayList<DanhMuc> listItem;

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();
    }

    public void setViewHome(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
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

        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case "PhongTro":
                    node = new PhongTroJPanel();
                    break;
                case "KhachThue":
                    node = new KhachThueJPanel();
                    break;
                case "HoaDon":
                    node = new HoaDonJPanel();
                    break;
                default:
                    node = new TrangChuJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangBackground(kind);
        }

        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(33, 120, 107));
            jlbItem.setBackground(new Color(33, 120, 107));
        }

        public void mouseReleased(MouseEvent e) {
            jpnItem.setBackground(new Color(97, 212, 195));
            jlbItem.setBackground(new Color(97, 212, 195));
        }

        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(33, 120, 107));
            jlbItem.setBackground(new Color(33, 120, 107));
        }

        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(97, 212, 195));
                jlbItem.setBackground(new Color(97, 212, 195));
            }
        }

        public void setChangBackground(String kind) {
            for (DanhMuc i : listItem) {
                if (i.getKind().equalsIgnoreCase(kind)) {
                    i.getJpn().setBackground(new Color(33, 120, 107));
                    i.getJlb().setBackground(new Color(33, 120, 107));

                } else {
                    i.getJpn().setBackground(new Color(97, 212, 195));
                    i.getJlb().setBackground(new Color(97, 212, 195));

                }
            }
        }

    }

}
