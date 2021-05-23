package Exercise3_18126035;

import java.util.Scanner;

public class HinhChuNhat extends HinhHoc {
	private double chieuDai, chieuRong;

	public HinhChuNhat() {
		super();
		chieuDai = 0;
		chieuRong = 0;

	}

	public double getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}

	public double getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chieu dai: ");
		this.chieuDai = Double.parseDouble(sc.nextLine());

		System.out.print("Nhap chieu rong: ");
		this.chieuRong = Double.parseDouble(sc.nextLine());

		if (chieuRong > chieuDai) {
			double temp = chieuDai;
			chieuDai = chieuRong;
			chieuRong = temp;
		}

	}

	@Override
	public void Output() {
		System.out.println("Do dai: chieu dai = " + chieuDai + " chieu rong: " + chieuRong);
		System.out.println("Chu vi: " + this.chuVi() + "\t Dien tich: " + this.dienTich());

	}

	@Override
	public double chuVi() {
		double p = (chieuDai + chieuRong) * 2;
		return Math.round(p * 100.0) / 100.0;

	}

	@Override
	public double dienTich() {

		double s = chieuDai * chieuRong;
		return Math.round(s * 100.0) / 100.0;
	}

}
