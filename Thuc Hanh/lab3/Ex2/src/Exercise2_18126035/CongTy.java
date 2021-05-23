package Exercise2_18126035;

import java.util.ArrayList;
import java.util.Scanner;

public class CongTy {
	private ArrayList<NhanVien> cty;

	public CongTy() {
		cty = new ArrayList<NhanVien>();
	}

	public ArrayList<NhanVien> getCty() {
		return cty;
	}

	public void setCty(ArrayList<NhanVien> cty) {
		this.cty = cty;
	}

	public void Input() {
		System.out.print("Enter numbers of staff in company: ");
		int n = new Scanner(System.in).nextInt();

		for (int i = 0; i < n;) {
			System.out.print(
					"Enter type of staff: 1 is Nhan Vien Cong Nhat; 2 is Nhan Vien San Xuat; 3 is Nhan Vien Quan Ly: ");
			int choose = new Scanner(System.in).nextInt();

			NhanVien nv;
			if (choose == 1)
				nv = new NhanVienCongNhat();
			else if (choose == 2)
				nv = new NhanVienSanXuat();
			else if (choose == 3)
				nv = new NhanVienQuanLy();
			else {
				System.out.println("Wrong Systax, Please enter again. ");
				continue;
			}
			nv.Input();
			System.out.println("\n");
			this.cty.add(nv);
			i++;

		}

	}

	public void Output() {
		for (NhanVien nv : cty) {
			nv.Output();
			System.out.println();
		}

	}

	// tong tien cty phai tra cho nhan vien
	public double ctyPaid() {
		int sum = 0;
		for (NhanVien nv : cty) {
			sum += nv.Salary();
		}
		return sum;
	}
}
