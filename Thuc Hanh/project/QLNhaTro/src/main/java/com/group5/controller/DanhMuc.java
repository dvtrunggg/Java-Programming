/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.controller;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author trung
 */
public class DanhMuc {

    private String kind;
    private JPanel jpn;
    private JLabel jlb;

    public DanhMuc() {
    }

    public DanhMuc(String kind, JPanel jpn, JLabel jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
    }

    public DanhMuc(String kind, JPanel jpn, JLabel jlb1, JLabel jlb2, JLabel jlb3) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb1;
        this.jlb = jlb2;
        this.jlb = jlb3;
    }


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
}
