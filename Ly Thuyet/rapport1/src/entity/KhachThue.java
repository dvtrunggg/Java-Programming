package entity;

import java.sql.Date;

public class KhachThue {
	private int idKhachThue;
	private String hoTen;
	private String soDienThoai;
	private String email;
	private Date ngaySinh;
	private String CMND;
	private String phuongTien;
	private String hoKhau;
	private String maPhong;
	private String maHoaDon;

	

	public int getIdKhachThue() {
		return idKhachThue;
	}

	public void setIdKhachThue(int idKhachThue) {
		this.idKhachThue = idKhachThue;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getPhuongTien() {
		return phuongTien;
	}

	public void setPhuongTien(String phuongTien) {
		this.phuongTien = phuongTien;
	}

	public String getHoKhau() {
		return hoKhau;
	}

	public void setHoKhau(String hoKhau) {
		this.hoKhau = hoKhau;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	
}
