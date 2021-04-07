package Lab4_18126035;

import java.util.ArrayList;
import java.util.Scanner;

public class MachNoiTiep extends MachPhuc {
	private ArrayList<MachDon> listNoiTiep;

	public MachNoiTiep() {
		listNoiTiep = new ArrayList<>();

	}

	public void Input() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhap so luong thiet bi: ");
		int sl = sc.nextInt();
		for (int j = 0; j < sl; j++) {
			MachDon md = new MachDon();
			md.Input();
			listNoiTiep.add(md);
		}
	}

	public void Output() {
		System.out.println("Mach Noi Tiep: ");
		for (MachDon md : listNoiTiep) {
			md.Output();
		}
		System.out.print("Co tong tro: " + this.tongTro());

	}

	public double tongTro() {
		double sum = 0;

		for (MachDon mss : listNoiTiep) {
			sum += mss.giaTriDienTro;
		}
		return sum;
	}

	public String Inf() {

		return "Mach Noi Tiep" + "," + this.tongTro();
	}
}
