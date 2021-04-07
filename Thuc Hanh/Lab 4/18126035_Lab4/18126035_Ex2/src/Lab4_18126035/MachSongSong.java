package Lab4_18126035;

import java.util.ArrayList;
import java.util.Scanner;

public class MachSongSong extends MachPhuc {
	private ArrayList<MachDon> listSongSong;

	public MachSongSong() {
		listSongSong = new ArrayList<>();
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhap so luong thiet bi: ");
		int sl = sc.nextInt();
		for (int j = 0; j < sl; j++) {
			MachDon md = new MachDon();
			md.Input();
			listSongSong.add(md);

		}

	}

	public void Output() {

		System.out.println("Mach Song Song: ");
		for (MachDon md : listSongSong) {
			md.Output();
		}
		System.out.print("Co tong tro: " + this.tongTro());

	}

	public double tongTro() {
		double sum = 0;
		double mul = 1;
		for (MachDon mss : listSongSong) {
			sum += mss.giaTriDienTro;
			mul *= mss.giaTriDienTro;
		}
		return mul / sum;
	}

	public String Inf() {
		return "Mach Song Song" + "," + this.tongTro();
	}

}
