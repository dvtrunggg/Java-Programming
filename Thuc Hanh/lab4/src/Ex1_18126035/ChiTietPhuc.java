package Ex1_18126035;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class ChiTietPhuc extends ChiTiet {
	private int soLuongChiTiet;
	private ArrayList<ChiTiet> listChiTiet;

	public static int slCTDon = 0;

	public ChiTietPhuc() {
		super();
		soLuongChiTiet = 0;
		listChiTiet = new ArrayList<>();
		this.Name = "Chi Tiet Phuc";
	}

	public int getSoLuongChiTiet() {
		return soLuongChiTiet;
	}

	public void setSoLuongChiTiet(int soLuongChiTiet) {
		this.soLuongChiTiet = soLuongChiTiet;
	}

	public ArrayList<ChiTiet> getListChiTiet() {
		return listChiTiet;
	}

	public void setListChiTiet(ArrayList<ChiTiet> listChiTiet) {
		this.listChiTiet = listChiTiet;
	}

	public int getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

	public void Input() {

		UUID uuid = UUID.randomUUID();
		this.maChiTiet = uuid.toString().replace("-", "").substring(0, 8);

		Scanner sc = new Scanner(System.in);

		System.out.print("Nhap so luong chi tiet thanh phan cua danh sach chi tiet phuc: ");
		this.soLuongChiTiet = sc.nextInt();

		for (int i = 0; i < soLuongChiTiet;) {
			System.out.print("Nhap thong tin chi tiet thanh phan (1 - Chi Tiet Don, 2 - Chi Tiet Thanh Phan Phuc): ");
			int choose = sc.nextInt();

			ChiTiet chiTiet;
			if (choose == 1) {
				chiTiet = new ChiTietDon();
				slCTDon++;
			} else if (choose == 2) {
				chiTiet = new MotChiTietPhuc();
			} else {
				System.out.println("Sai cu phap, moi nhap lai! ");
				continue;
			}

			System.out.println(chiTiet.Name);
			chiTiet.Input();
			giaTien += chiTiet.giaTien;
			listChiTiet.add(chiTiet);

			i++;
		}
	}

	public void Output() {

		System.out.println(this.Name + "\t\tMa chi tiet: " + this.maChiTiet);
		System.out.println("So luong chi tiet thanh phan: " + soLuongChiTiet);
		for (ChiTiet ct : listChiTiet) {
			ct.Output();
			System.out.println();
		}

		System.out.println("Gia Tien: " + giaTien);
	}
	
	public void Output2() {

		System.out.println(this.Name + "\t\tMa chi tiet: " + this.maChiTiet);
		for (ChiTiet ct : listChiTiet) {
			ct.Output();
			System.out.println();
		}

		System.out.println("Gia Tien: " + giaTien);
	}

	public int tinhTien() {
		return giaTien;
	}

	public String Inf() {
		String line = "";
		line += this.Name + "," + this.maChiTiet + "," + this.giaTien + "\n";
		for (int i = 0; i < listChiTiet.size(); i++) {
			line += "\t" + listChiTiet.get(i).Inf();
			if (i < listChiTiet.size() - 1)
				line += "\n";
		}
		return line;
	}

}
