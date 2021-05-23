package Exercise1_18126035;

import java.util.Scanner;

public class GiangVienThinhGiang extends GiangVien {
	private String workPlace;

	public GiangVienThinhGiang() {
		super();

	}

	public GiangVienThinhGiang(String name, String email, String phone, int teachingTime, String workPlace) {
		super(name, email, phone, teachingTime);
		this.workPlace = workPlace;
	}

	public GiangVienThinhGiang(String workPlace) {
		super();
		this.workPlace = workPlace;
	}

	public GiangVienThinhGiang(GiangVienThinhGiang gv) {
		this.name = gv.name;
		this.email = gv.email;
		this.phone = gv.phone;
		this.teachingTime = gv.teachingTime;
		this.workPlace = gv.workPlace;
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);
		super.Input();
		System.out.print("Enter Teacher's Work Place: ");
		workPlace = sc.nextLine();

	}

	public void Output() {
		super.Output();
		System.out.println("Work Place: " + workPlace);
		System.out.println("Total Salary received: " + this.tienLuong());
		
	}

	public double tienLuong() {
		return 200000 * teachingTime;
	}

}
