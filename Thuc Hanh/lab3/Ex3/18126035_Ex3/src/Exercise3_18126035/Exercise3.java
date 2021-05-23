package Exercise3_18126035;

import java.util.Scanner;

public class Exercise3 {
	public static void main(String[] args) {
		DanhSach ds = new DanhSach();

		ds.Input();
		System.out.println("Danh sach cac hinh: ");
		ds.Output();

		System.out.println("Tong chu vi cac hinh trong ds: " + ds.tongChuVi());
		System.out.println("Tong dien tich cac hinh trong ds: " + ds.tongDienTich());

		System.out.println();
		System.out.println("Hinh co chu vi lon nhat: ");
		for (HinhHoc hh : ds.chuViLonNhat()) {
			System.out.println(hh.getTenHinh());
			hh.Output();
			System.out.println();
		}

		System.out.println("Hinh co dien tich lon nhat: ");
		for (HinhHoc hh : ds.dienTichLonNhat()) {
			System.out.println(hh.getTenHinh());
			hh.Output();
			System.out.println();
		}

		System.out.println("Loai hinh co chu vi lon nhat: " + ds.ChuVi_LarestType());
		System.out.println("Loai hinh co dien tich lon nhat: " + ds.DienTich_LarestType());

//		System.out.println("Loai hinh co chu vi lon nhat (cach 2): ");
//		ds.ChuVi_LarestType2();
//		System.out.println("Loai hinh co dien tich lon nhat (cach 2): ");
//		ds.DienTich_LarestType2();

		System.out.println("HCN co chu vi lon nhat: ");
		ds.chuViLonNhat_HCN();
		System.out.println();

		System.out.println("HCN co dien tich lon nhat: ");
		ds.dienTichLonNhat_HCN();
		System.out.println();

		System.out.println("Hinh Tam Giac co chu vi lon nhat: ");
		ds.chuViLonNhat_TamGiac();
		System.out.println();

		System.out.println("Hinh Tam Giac co dien tich lon nhat: ");
		ds.dienTichLonNhat_TamGiac();
		System.out.println();

		System.out.println("Hinh Tron co chu vi lon nhat: ");
		ds.chuViLonNhat_HTron();
		System.out.println();

		System.out.println("Hinh Tron co dien tich lon nhat: ");
		ds.dienTichLonNhat_HTron();

	}
}
