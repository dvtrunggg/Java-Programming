package Exercise2_18126035;

import java.util.Scanner;

public class NhanVienSanXuat extends NhanVien{
	private int productsNum;

	public NhanVienSanXuat() {
		super();
		
	}

	public NhanVienSanXuat(String name, String dateBirth, String address, int productsNum) {
		super(name, dateBirth, address);
		this.productsNum = productsNum;
	}
	
	public NhanVienSanXuat(NhanVienSanXuat nv)
	{
		this.Name = nv.Name;
		this.Address = nv.Address;
		this.dateBirth = dateBirth;
		this.productsNum = productsNum;
	}
	
	public void Input()
	{
		super.Input();
		System.out.print("Enter numbers of product: ");
		this.productsNum = new Scanner(System.in).nextInt();
		
	}
	
	public void Output()
	{
		super.Output();
		System.out.println("Numbers of product: " + productsNum);
		System.out.println("Salary received: " + this.Salary());

	}
	
	public double Salary()
	{
		return 20000 * this.productsNum;
	}
	
	
}
