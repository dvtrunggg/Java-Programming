package entity;

import java.sql.Date;

public class HoaDon {
	private int idHoaDon;
	private int maPhong;
	private Date startDate;
	private Date endDate;
	private int giaDien;
	private int giaNuoc;
	private int soDien;
	private int soNuoc;
	private int giaPhong;

	public int getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getGiaDien() {
		return giaDien;
	}

	public void setGiaDien(int giaDien) {
		this.giaDien = giaDien;
	}

	public int getGiaNuoc() {
		return giaNuoc;
	}

	public void setGiaNuoc(int giaNuoc) {
		this.giaNuoc = giaNuoc;
	}

	public int getSoDien() {
		return soDien;
	}

	public void setSoDien(int soDien) {
		this.soDien = soDien;
	}

	public int getSoNuoc() {
		return soNuoc;
	}

	public void setSoNuoc(int soNuoc) {
		this.soNuoc = soNuoc;
	}

	public int getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(int giaPhong) {
		this.giaPhong = giaPhong;
	}

}
