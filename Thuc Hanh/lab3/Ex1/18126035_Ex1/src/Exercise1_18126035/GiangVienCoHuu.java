package Exercise1_18126035;

import java.util.Scanner;

public class GiangVienCoHuu extends GiangVien {
	private int salary;
	private int quyDinhTime;

	public GiangVienCoHuu() {
		super();
	}

	public GiangVienCoHuu(String name, String email, String phone, int teachingTime, int salary, int quyDinhTime) {
		super(name, email, phone, teachingTime);
		this.salary = salary;
		this.quyDinhTime = quyDinhTime;
	}

	public int getSalary() {
		return salary;
	}

	public GiangVienCoHuu(int salary, int quyDinhTime) {
		super();
		this.salary = salary;
		this.quyDinhTime = quyDinhTime;
	}
	
	public GiangVienCoHuu(GiangVienCoHuu gv)
	{
		this.name = gv.name;
		this.email = gv.email;
		this.phone = gv.phone;
		this.teachingTime = gv.teachingTime;
		this.quyDinhTime = gv.quyDinhTime;
		this.salary = gv.salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getQuyDinhTime() {
		return quyDinhTime;
	}

	public void setQuyDinhTime(int quyDinhTime) {
		this.quyDinhTime = quyDinhTime;
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);
		super.Input();
		System.out.print("Enter Teacher's Salary: ");
		salary = sc.nextInt();

		System.out.print("Enter Teacher's Quy Dinh Time: ");
		quyDinhTime = sc.nextInt();

	}

	public void Output() {
		super.Output();
		System.out.println("Salary: " + salary + "\tQuy Dinh Time: " + quyDinhTime);
		System.out.println("Total Salary received: " + this.tienLuong());
	}

	// tong tien luong nhan dc moi thang
	public double tienLuong() {
		// 1 gio day = 200.000
		return this.salary + 200000 * (this.teachingTime - this.quyDinhTime);
	}

}
