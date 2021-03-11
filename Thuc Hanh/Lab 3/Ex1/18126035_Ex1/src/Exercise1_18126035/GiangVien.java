package Exercise1_18126035;

import java.util.Scanner;

public abstract class GiangVien {
	protected String name;
	protected String email;
	protected String phone;
	protected int teachingTime;

	public GiangVien() {
		this.name = "";
		this.email = "";
		this.phone = "";
		this.teachingTime = 0;
	}

	public GiangVien(String name, String email, String phone, int teachingTime) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.teachingTime = teachingTime;
	}

	public GiangVien(GiangVien gv) {
		this.name = gv.name;
		this.email = gv.email;
		this.phone = gv.phone;
		this.teachingTime = gv.teachingTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTeachingTime() {
		return teachingTime;
	}

	public void setTeachingTime(int teachingTime) {
		this.teachingTime = teachingTime;
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Teacher Name: ");
		this.name = sc.nextLine();

		System.out.print("Enter Teacher Email: ");
		this.email = sc.nextLine();

		System.out.print("Enter Teacher Phone: ");
		this.phone = sc.nextLine();

		System.out.print("Enter Teacher Teaching Time: ");
		this.teachingTime = sc.nextInt();

	}

	public void Output() {
		System.out.println("Name: " + this.name + "\tEmail: " + this.email);
		System.out.println("Phone: " + this.phone + "\tTeaching Time In 1 month: " + this.teachingTime);
	}

	public abstract double tienLuong();

}
