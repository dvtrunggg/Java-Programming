package Exercise2_18126035;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract  class NhanVien {
	protected String Name;
	protected String dateBirth;
	protected String Address;

	public NhanVien() {
		this.Name = "";
		this.dateBirth = "";
		this.Address = "";

	}

//	// convert string to date
//	public static Date Convert(String str) {
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
//		try {
//			date = sdf.parse(str);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		return date;
//
//	}

	public NhanVien(String name, String dateBirth, String address) {

		this.Name = name;
		this.Address = address;
		this.dateBirth = dateBirth;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Staff's Name: ");
		this.Name = sc.nextLine();

		System.out.print("Enter Date Of Birth (dd/mm/yyyy): ");
		this.dateBirth = sc.nextLine();

		System.out.print("Enter Address: ");
		this.Address = sc.nextLine();

	}

	public void Output() {
		System.out.println("Name: " + Name + "\t\t Date of Birth:" + dateBirth + "\t\t Adress: " + Address);
	}
	
	public abstract double Salary();

}
