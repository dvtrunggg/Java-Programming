package Exercise2_18126035;

import java.util.Scanner;

public class NhanVienCongNhat extends NhanVien {

	private int workingDays; //so ngay cong

	public NhanVienCongNhat() {
		super();
		
	}

	public NhanVienCongNhat(String name, String dateBirth, String address, int workingDays) {
		super(name, dateBirth, address);
		this.workingDays = workingDays;
	}
	
	public NhanVienCongNhat(NhanVienCongNhat nv)
	{
		this.Name = nv.Name;
		this.Address = nv.Address;
		this.dateBirth = dateBirth;
		this.workingDays = workingDays;
	}
	
	public void Input()
	{
		super.Input();
		System.out.print("Enter numbers of working days: ");
		this.workingDays = new Scanner(System.in).nextInt();
		
	}
	
	public void Output()
	{
		super.Output();
		System.out.println("Numbers of working days: " + workingDays);
		System.out.println("Salary received: " + this.Salary());
	}
	
	public double Salary()
	{
		return 50000 * this.workingDays;
	}

}
