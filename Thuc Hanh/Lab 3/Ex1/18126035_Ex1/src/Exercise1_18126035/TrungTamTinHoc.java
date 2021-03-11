package Exercise1_18126035;

import java.util.ArrayList;
import java.util.Scanner;

public class TrungTamTinHoc {
	private ArrayList<GiangVien> List;

	public TrungTamTinHoc() {
		List = new ArrayList<>();
	}

	public ArrayList<GiangVien> getList() {
		return List;
	}

	public void setList(ArrayList<GiangVien> list) {
		List = list;
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter numbers of teacher:  ");
		int n = sc.nextInt();

		for (int i = 0; i < n;) {
			System.out.print("Add Teacher: press 1 to add Giang Vien Co Huu; press 2 to add Giang Vien Thinh Giang: ");
			int choose = sc.nextInt();

			GiangVien gv;
			if (choose == 1) {
				gv = new GiangVienCoHuu();
			} else if (choose == 2) {
				gv = new GiangVienThinhGiang();
			} else {
				System.out.println("Wrong Systax, Please Enter again: ");
				continue;
			}
			i++;

			gv.Input();
			List.add(gv);
			System.out.println("\n");

		}
	}

	public void Output() {
		for (GiangVien gv : List) {
			gv.Output();
			System.out.println("\n");
		}
	}

	public void OutputGVCoHuu() {
		for (GiangVien gv : List) {
			if (gv instanceof GiangVienCoHuu) {
				gv.Output();
			}
		}
	}

	public void OutputGVThinhGiang() {
		for (GiangVien gv : List) {
			if (gv instanceof GiangVienThinhGiang) {
				gv.Output();
			}
		}
	}

	public double tongLuong() {
		double sum = 0;
		for (GiangVien gv : List) {
			sum += gv.tienLuong();
		}
		return sum;
	}

	// loai giang vien co luong cao nhat
	public void loaiGiangVien() {
		double sum1 = 0;
		double sum2 = 0;

		for (GiangVien gv : List) {
			if (gv instanceof GiangVienCoHuu) {
				sum1 += gv.tienLuong();
			}

			else if (gv instanceof GiangVienThinhGiang) {
				sum2 += gv.tienLuong();
			}
		}

		if (sum1 < sum2) {
			System.out.println("Giang Vien Thinh Giang has highest salary.");
		}

		else if (sum1 > sum2) {
			System.out.println("Giang Vien Co Huu has highest salary.");
		}

		else {
			System.out.println("Total salary Giang Vien Co Huu = Total salary Giang Vien Thinh Giang.");
		}

	}

}
