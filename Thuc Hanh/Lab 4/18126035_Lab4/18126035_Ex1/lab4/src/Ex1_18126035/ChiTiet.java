package Ex1_18126035;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public abstract class ChiTiet {
	protected String maChiTiet;
	protected String Name;
	protected int giaTien;

	public ChiTiet(String maChiTiet, String name, int giaTien) {
		this.maChiTiet = maChiTiet;
		this.Name = name;
		this.giaTien = giaTien;
	}

	public ChiTiet() {
		maChiTiet = "";
		Name = "";
		this.giaTien = 0;
	}

	public String getMaChiTiet() {
		return maChiTiet;
	}

	public void setMaChiTiet(String maChiTiet) {
		this.maChiTiet = maChiTiet;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

//	// random maChiTiet
//	public static String RanDomID(String id) {
//		UUID uuid = UUID.randomUUID();
//		id = uuid.toString().replace("-", "").substring(0, 8);
//		return id;
//	}

	public void Input() {

		UUID uuid = UUID.randomUUID();
		this.maChiTiet = uuid.toString().replace("-", "").substring(0, 8);

		Scanner sc = new Scanner(System.in);

		System.out.print("Nhap Gia Tien: ");
		this.giaTien = sc.nextInt();
	}

	public void Output() {
		System.out.println(this.Name);
		System.out.println("Ma Chi Tiet: " + maChiTiet + "\t\t Gia Tien: " + giaTien);
	}

	public void Output2() {
		System.out.println(this.Name);
		System.out.println("Ma Chi Tiet: " + maChiTiet + "\t\t Gia Tien: " + giaTien);
	}

	abstract int tinhTien();

	abstract String Inf();

}
