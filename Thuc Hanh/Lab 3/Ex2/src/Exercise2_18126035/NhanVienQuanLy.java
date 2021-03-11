package Exercise2_18126035;

import java.util.Scanner;

public class NhanVienQuanLy extends NhanVien {

	private double heSoLuong; //so ngay cong
	private int basicSalary;

	public NhanVienQuanLy() {
		super();
		
	}

	public NhanVienQuanLy(String name, String dateBirth, String address, int heSoLuong, int basicSalary) {
		super(name, dateBirth, address);
		this.heSoLuong = heSoLuong;
		this.basicSalary = basicSalary;
	}
	
	public NhanVienQuanLy(NhanVienQuanLy nv)
	{
		this.Name = nv.Name;
		this.Address = nv.Address;
		this.dateBirth = dateBirth;
		this.heSoLuong = heSoLuong;
		this.basicSalary = basicSalary;
	}
	
	public void Input()
	{
		super.Input();
		System.out.print("Enter Basic Salary: ");
		this.basicSalary = new Scanner(System.in).nextInt();
		
		System.out.print("Enter He So Luong: ");
		this.heSoLuong = new Scanner(System.in).nextDouble();
		
	}
	
	public void Output()
	{
		super.Output();
		System.out.println("He So Luong: " + heSoLuong + "\t\t Basic Salary: " + basicSalary);
		System.out.println("Salary received: " + this.Salary());

	}
	
	public double Salary()
	{
		return basicSalary * heSoLuong;
	}

}
