package Exercise3_18126035;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class DanhSach {
	private ArrayList<HinhHoc> list;

	public DanhSach() {
		list = new ArrayList<>();
	}

	//nhap danh sach hinh hoc
	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong hinh hoc: ");
		int n = sc.nextInt();

		for (int i = 0; i < n;) {
			System.out.print("Nhap hinh hoc: tam giac: 1; hinh chu nhat: 2; hinh tron: 3: ");
			int choose = sc.nextInt();

			HinhHoc hh;
			if (choose == 1) {
				hh = new HinhTamGiac();
			} else if (choose == 2) {
				hh = new HinhChuNhat();
			} else if (choose == 3) {
				hh = new HinhTron();
			} else {
				System.out.print("Wrong Systax!, please enter again!");
				continue;
			}

			hh.Input();
			System.out.println();
			list.add(hh);
			i++;
		}

	}

	//xuat danh sach hinh hoc
	public void Output() {

		for (HinhHoc hh : this.list) {
			if (hh instanceof HinhTron)
				hh.setTenHinh("Hinh Tron");
			else if (hh instanceof HinhTamGiac)
				hh.setTenHinh("Hinh Tam Giac");
			else if (hh instanceof HinhChuNhat)
				hh.setTenHinh("Hinh Chu Nhat");

			System.out.println(hh.tenHinh);
			hh.Output();
			System.out.println();
		}
	}

	// tong chu vi cac hinh
	public double tongChuVi() {
		double sum = 0;
		for (HinhHoc hh : list) {
			sum += hh.chuVi();
		}
		return sum;
	}

	// tong dien tich cac hinh
	public double tongDienTich() {
		double sum = 0;
		for (HinhHoc hh : list) {
			sum += hh.dienTich();
		}
		return sum;
	}

	// hinh co chu vi lon nhat
	public ArrayList<HinhHoc> chuViLonNhat() {
		double largestChuVi = list.get(0).chuVi();
		for (int i = 1; i < list.size(); i++) {
			if (largestChuVi < list.get(i).chuVi())
				largestChuVi = list.get(i).chuVi();
		}

		ArrayList<HinhHoc> ds = new ArrayList<>();
		for (HinhHoc hh : list) {
			if (largestChuVi == hh.chuVi())
				ds.add(hh);
		}

		return ds;
	}

	// hinh co dien tich lon nhat
	public ArrayList<HinhHoc> dienTichLonNhat() {
		double largestDienTich = list.get(0).dienTich();
		for (int i = 1; i < list.size(); i++) {
			if (largestDienTich < list.get(i).dienTich())
				largestDienTich = list.get(i).dienTich();
		}

		ArrayList<HinhHoc> ds = new ArrayList<>();
		for (HinhHoc hh : list) {
			if (largestDienTich == hh.dienTich())
				ds.add(hh);
		}

		return ds;
	}

	// cach 1: loai hinh co chu vi lon nhat (dung hashmap):
	public HashMap<String, Double> ChuVi_LarestType() {
		double tongP_TamGiac = 0;
		double tongP_HinhTron = 0;
		double tongP_HCN = 0;
		for (HinhHoc hh : this.list) {
			if (hh instanceof HinhChuNhat)
				tongP_HCN += hh.chuVi();

			else if (hh instanceof HinhTamGiac)
				tongP_TamGiac += hh.chuVi();

			else if (hh instanceof HinhTron)
				tongP_HinhTron += hh.chuVi();
		}

		HashMap<String, Double> hm = new HashMap<>();
		hm.put("Hinh Tron", tongP_HinhTron);
		hm.put("Hinh Chu Nhat", tongP_HCN);
		hm.put("Hinh Tam Giac", tongP_TamGiac);

		double max = Collections.max(hm.values());
		Set<String> key = hm.keySet();

		HashMap<String, Double> result = new HashMap<>();
		for (String k : key) {
			if (max == hm.get(k))
				result.put(k, max);
		}
		return result;
	}

	// cach 2: loai hinh co chu vi lon nhat
	public void ChuVi_LarestType2() {

		double tongP_TamGiac = 0;
		double tongP_HinhTron = 0;
		double tongP_HCN = 0;
		for (HinhHoc hh : this.list) {
			if (hh instanceof HinhChuNhat)
				tongP_HCN += hh.chuVi();

			else if (hh instanceof HinhTamGiac)
				tongP_TamGiac += hh.chuVi();

			else if (hh instanceof HinhTron)
				tongP_HinhTron += hh.chuVi();
		}

		double max = Math.max(Math.max(tongP_TamGiac, tongP_HCN), tongP_HinhTron);
		if (max == tongP_HCN) {
			System.out.println("Hinh chu nhat co tong dien tich lon nhat: " + tongP_HCN);
		}

		if (max == tongP_TamGiac) {
			System.out.println("Hinh tam giac co tong dien tich lon nhat: " + tongP_TamGiac);
		}

		if (max == tongP_HinhTron) {
			System.out.println("Hinh tron co tong dien tich lon nhat: " + tongP_HinhTron);
		}
	}

	// cach 1: loai co dien tich lon nhat (dung hash map):
	public HashMap<String, Double> DienTich_LarestType() {
		double tongS_TamGiac = 0;
		double tongS_HinhTron = 0;
		double tongS_HCN = 0;
		for (HinhHoc hh : this.list) {
			if (hh instanceof HinhChuNhat)
				tongS_HCN += hh.dienTich();

			else if (hh instanceof HinhTamGiac)
				tongS_TamGiac += hh.dienTich();

			else if (hh instanceof HinhTron)
				tongS_HinhTron += hh.dienTich();
		}

		HashMap<String, Double> hm = new HashMap<>();
		hm.put("Hinh Tron", tongS_HinhTron);
		hm.put("Hinh Chu Nhat", tongS_HCN);
		hm.put("Hinh Tam Giac", tongS_TamGiac);

		double max = Collections.max(hm.values());
		Set<String> key = hm.keySet();

		HashMap<String, Double> result = new HashMap<>();
		for (String k : key) {
			if (max == hm.get(k))
				result.put(k, max);
		}
		return result;
	}

	// cach 2: loai hinh co dien tich lon nhat
	public void DienTich_LarestType2() {

		double tongS_TamGiac = 0;
		double tongS_HinhTron = 0;
		double tongS_HCN = 0;
		for (HinhHoc hh : this.list) {
			if (hh instanceof HinhChuNhat)
				tongS_HCN += hh.dienTich();

			else if (hh instanceof HinhTamGiac)
				tongS_TamGiac += hh.dienTich();

			else if (hh instanceof HinhTron)
				tongS_HinhTron += hh.dienTich();
		}

		double max = Math.max(Math.max(tongS_TamGiac, tongS_HCN), tongS_HinhTron);
		if (max == tongS_HCN) {
			System.out.println("Hinh chu nhat co tong dien tich lon nhat: " + tongS_HCN);
		}

		if (max == tongS_TamGiac) {
			System.out.println("Hinh tam giac co tong dien tich lon nhat: " + tongS_TamGiac);
		}

		if (max == tongS_HinhTron) {
			System.out.println("Hinh tron co tong dien tich lon nhat: " + tongS_HinhTron);
		}

	}

	// hinh chu nhat co chu vi lon nhat
	public void chuViLonNhat_HCN() {
		ArrayList<HinhHoc> l = new ArrayList<>();
		for (HinhHoc hh : list) {
			if (hh instanceof HinhChuNhat) {
				l.add(hh);
			}
		}

		if (l.size() == 0) {
			System.out.println("Khong co HCN trong danh sach.");
			return;
		}

		else {
			double max = l.get(0).chuVi();
			for (int i = 0; i < l.size(); i++) {
				if (max < l.get(i).chuVi()) {
					max = l.get(i).chuVi();
				}
			}
			
			for (HinhHoc hh : l) {
				if(max == hh.chuVi())
					hh.Output();
			}
		}

	}
	
	
	// hinh chu nhat co dien tich lon nhat
	public void dienTichLonNhat_HCN() {
		ArrayList<HinhHoc> l = new ArrayList<>();
		for (HinhHoc hh : list) {
			if (hh instanceof HinhChuNhat) {
				l.add(hh);
			}
		}

		if (l.size() == 0) {
			System.out.println("Khong co HCN trong danh sach.");
			return;
		}

		else {
			double max = l.get(0).dienTich();
			for (int i = 0; i < l.size(); i++) {
				if (max < l.get(i).dienTich()) {
					max = l.get(i).dienTich();
				}
			}
			
			for (HinhHoc hh : l) {
				if(max == hh.dienTich())
					hh.Output();
			}
		}

	}
	
	
	
	// hinh tron co chu vi lon nhat
	public void chuViLonNhat_HTron() {
		ArrayList<HinhHoc> l = new ArrayList<>();
		for (HinhHoc hh : list) {
			if (hh instanceof HinhTron) {
				l.add(hh);
			}
		}

		if (l.size() == 0) {
			System.out.println("Khong co Hinh Tron trong danh sach.");
			return;
		}

		else {
			double max = l.get(0).chuVi();
			for (int i = 0; i < l.size(); i++) {
				if (max < l.get(i).chuVi()) {
					max = l.get(i).chuVi();
				}
			}
			
			for (HinhHoc hh : l) {
				if(max == hh.chuVi())
					hh.Output();
			}
		}

	}
	
	
	// hinh tron co dien tich lon nhat
	public void dienTichLonNhat_HTron() {
		ArrayList<HinhHoc> l = new ArrayList<>();
		for (HinhHoc hh : list) {
			if (hh instanceof HinhTron) {
				l.add(hh);
			}
		}

		if (l.size() == 0) {
			System.out.println("Khong co Hinh Tron trong danh sach.");
			return;
		}

		else {
			double max = l.get(0).dienTich();
			for (int i = 0; i < l.size(); i++) {
				if (max < l.get(i).dienTich()) {
					max = l.get(i).dienTich();
				}
			}
			
			for (HinhHoc hh : l) {
				if(max == hh.dienTich())
					hh.Output();
			}
		}

	}
	
	// hinh tam giac co chu vi lon nhat
	public void chuViLonNhat_TamGiac() {
		ArrayList<HinhHoc> l = new ArrayList<>();
		for (HinhHoc hh : list) {
			if (hh instanceof HinhTamGiac) {
				l.add(hh);
			}
		}

		if (l.size() == 0) {
			System.out.println("Khong co Hinh Tam Giac trong danh sach.");
			return;
		}

		else {
			double max = l.get(0).chuVi();
			for (int i = 0; i < l.size(); i++) {
				if (max < l.get(i).chuVi()) {
					max = l.get(i).chuVi();
				}
			}
			
			for (HinhHoc hh : l) {
				if(max == hh.chuVi())
					hh.Output();
			}
		}

	}
	
	// hinh tam giac co dien tich lon nhat
	public void dienTichLonNhat_TamGiac() {
		ArrayList<HinhHoc> l = new ArrayList<>();
		for (HinhHoc hh : list) {
			if (hh instanceof HinhTamGiac) {
				l.add(hh);
			}
		}

		if (l.size() == 0) {
			System.out.println("Khong co Hinh Tam Giac trong danh sach.");
			return;
		}

		else {
			double max = l.get(0).dienTich();
			for (int i = 0; i < l.size(); i++) {
				if (max < l.get(i).dienTich()) {
					max = l.get(i).dienTich();
				}
			}
			
			for (HinhHoc hh : l) {
				if(max == hh.dienTich())
					hh.Output();
			}
		}

	}

}
