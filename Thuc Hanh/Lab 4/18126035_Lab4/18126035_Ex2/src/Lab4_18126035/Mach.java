package Lab4_18126035;

import java.util.Scanner;

public abstract class Mach {
	protected int giaTriDienTro;
	protected String Name;

	public Mach() {
		giaTriDienTro = 0;
		Name = "";
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getGiaTriDienTro() {
		return giaTriDienTro;
	}

	public void setGiaTriDienTro(int giaTriDienTro) {
		this.giaTriDienTro = giaTriDienTro;
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap gia tri "+this.Name);
		giaTriDienTro = sc.nextInt();
	}


	
	public void Output() {
		System.out.println("Gia tri cua: " + this.Name + ": " + this.giaTriDienTro);
	}

}
