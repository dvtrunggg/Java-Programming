package Exercise3_18126035;

import java.util.Scanner;

public class HinhTron extends HinhHoc {
	private double banKinh;

	public HinhTron() {
		super();
		this.banKinh = 0;
	}

	public HinhTron(double banKinh) {
		super();
		this.banKinh = banKinh;
	}

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	@Override
	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ban kinh: ");
		this.banKinh = Double.parseDouble(sc.nextLine());

	}

	@Override
	public void Output() {
		System.out.println("Do dai: ban kinh " + this.banKinh);
		System.out.println("Chu vi: " + this.chuVi() + "\t Dien tich: " + this.dienTich());
	}

	public double chuVi() {
		double p = 2 * Math.PI * this.banKinh;
		return Math.round(p * 100.0) / 100.0;

	}

	public double dienTich() {
		double s = Math.PI * this.banKinh * this.banKinh;
		return Math.round(s * 100.0) / 100.0;

	}

}
