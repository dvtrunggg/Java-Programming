package Exercise3_18126035;

import java.util.Scanner;

public class HinhTamGiac extends HinhHoc {
	private double canhA, canhB, canhC;

	public HinhTamGiac() {
		super();
		this.canhA = 0;
		this.canhB = 0;
		this.canhC = 0;
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap canh a: ");
		this.canhA = Double.parseDouble(sc.nextLine());

		System.out.print("Nhap canh b: ");
		this.canhB = Double.parseDouble(sc.nextLine());;

		System.out.print("Nhap canh c: ");
		this.canhC = Double.parseDouble(sc.nextLine());

	}

	public void Output() {

		System.out.println("Do dai: canh a = " + canhA + " canh b = " + canhB + " canh c = " + canhC);
		System.out.println("Chu vi: " + this.chuVi() + "\t Dien tich: " + this.dienTich());

	}

	public double chuVi() {
		double p = canhA + canhB + canhC;
		return Math.round(p * 100.0) / 100.0;

	}

	public double dienTich() {
		double pHalf = this.chuVi() / 2;
		double s = Math.sqrt(pHalf * (pHalf - canhA) * (pHalf - canhB) * (pHalf - canhC));
		return Math.round(s * 100.0) / 100.0;
	}
}
