package Ex1_18126035;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class ChiTietMay implements Serializable {
	private ArrayList<ChiTiet> list;

	public ChiTietMay() {
		list = new ArrayList<>();

	}

	public ArrayList<ChiTiet> getList() {
		return list;
	}

	public void setList(ArrayList<ChiTiet> list) {
		this.list = list;
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong chi tiet may: ");
		int n = sc.nextInt();

		for (int i = 0; i < n;) {
			System.out.print("Nhap Chi Tiet (1 - Chi Tiet Don, 2 - Chi Tiet Phuc): ");
			int choose = sc.nextInt();

			ChiTiet chiTiet;
			if (choose == 1) {
				chiTiet = new ChiTietDon();
			} else if (choose == 2) {
				chiTiet = new ChiTietPhuc();
			} else {
				System.out.println("Sai cu phap, moi nhap lai! ");
				continue;
			}

			System.out.println(chiTiet.Name);
			chiTiet.Input();
			list.add(chiTiet);
			i++;
		}
	}

	public void Output() {
		for (ChiTiet ct : list) {
			ct.Output();
		}
	}
	
	public void Output2() {
		for (ChiTiet ct : list) {
			ct.Output2();
		}
	}

	public ArrayList<ChiTiet> Search(String id) {
		ArrayList<ChiTiet> ds = new ArrayList<>();
		for (ChiTiet ct : this.list) {
			if (id == ct.maChiTiet)
				ds.add(ct);
		}
		return ds;
	}

	public int giaTienChiTietDon() {
		int sum = 0;
		for (ChiTiet ct : this.list) {
			if (ct instanceof ChiTietDon)
				sum += ct.giaTien;
		}
		return sum;
	}

	public int giaTienChiTietPhuc() {
		int sum = 0;
		for (ChiTiet ct : this.list) {
			if (ct instanceof ChiTietPhuc)
				sum += ct.giaTien;
		}
		return sum;
	}

	public int giaTienMay() {
		int sum = 0;
		for (ChiTiet ct : this.list) {
			sum += ct.giaTien;
		}
		return sum;
	}

	public int soLuongChiTietDon() {
		int count = 0;
		ChiTietPhuc ctp = new ChiTietPhuc();
		for (ChiTiet ct : this.list) {
			if (ct instanceof ChiTietDon)
				count++;
		}

		return count + ctp.slCTDon;
	}

	public ArrayList<String> Inf() {
		ArrayList<String> listInf = new ArrayList<>();
		for (ChiTiet ct : list) {
			listInf.add(ct.Inf());
		}
		return listInf;
	}

	public boolean writeFile(String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);

			ArrayList<String> obj = this.Inf();

			for (String str : obj) {
				bw.write(str);
				bw.newLine();
			}

			bw.close();
			osw.close();
			fos.close();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public void readFile(String path) {
		ArrayList<ChiTietPhuc> listPhuc = new ArrayList<>();

		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();

			while (line != null) {
				String[] arr = line.split(",");

				if (arr.length == 3) {
					ChiTiet ct;
					ChiTietPhuc ctp;

					if (arr[0].equals("Chi Tiet Don")) {
						ct = new ChiTietDon();
						ct.Name = arr[0];
						ct.maChiTiet = arr[1];
						ct.giaTien = Integer.parseInt(arr[2]);
						list.add(ct);

					}

					else if (arr[0].equals("Chi Tiet Phuc")) {
						ct = new ChiTietPhuc();
						ct.Name = arr[0];
						ct.maChiTiet = arr[1];
						ct.giaTien = Integer.parseInt(arr[2]);
						list.add(ct);

					}

					else if (arr[0].equals("\tChi Tiet Don")) {
						ctp = new ChiTietPhuc();
						ctp.Name = arr[0];
						ctp.maChiTiet = arr[1];
						ctp.giaTien = Integer.parseInt(arr[2]);
						listPhuc.add(ctp);

					}

					else if (arr[0].equals("\tChi Tiet Thanh Phan Phuc")) {
						ctp = new ChiTietPhuc();
						ctp.Name = arr[0];
						ctp.maChiTiet = arr[1];
						ctp.giaTien = Integer.parseInt(arr[2]);

						listPhuc.add(ctp);

					}

				}
				line = br.readLine();

			}
			
			
			list.addAll(listPhuc);
			
			
			br.close();
			isr.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
