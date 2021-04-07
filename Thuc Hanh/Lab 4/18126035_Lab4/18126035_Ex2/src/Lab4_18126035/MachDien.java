package Lab4_18126035;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class MachDien {
	private ArrayList<MachPhuc> list;

	public MachDien() {
		list = new ArrayList<>();
	}

	public ArrayList<MachPhuc> getList() {
		return list;
	}

	public void setList(ArrayList<MachPhuc> list) {
		this.list = list;
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong mach phuc: ");
		int n = sc.nextInt();

		for (int i = 0; i < n;) {
			System.out.print("Nhap Loai mach (1 - Mach song song, 2 - Mach noi tiep): ");
			int choose = sc.nextInt();

			MachPhuc mp;
			if (choose == 1) {
				mp = new MachSongSong();
		
			} else if (choose == 2) {
				mp = new MachNoiTiep();
			} else {
				System.out.println("Sai cu phap, moi nhap lai! ");
				continue;
			}

			mp.Input();
			
			list.add(mp);
			i++;
		}
	}

	public void Output()
	{
		System.out.print("Mach gom: ");
		for (Mach m : list) {
			m.Output();
		}
		System.out.println("Tong tro: "+this.tongTro());
	}
	
	public double tongTro()
	{
		double sum = 0;
		for (MachPhuc mp : list) {
			sum+=mp.tongTro();
		}
		return sum;
	}
	
	public ArrayList<String> Inf()
	{
		ArrayList<String> l= new ArrayList<>();
		for (MachPhuc mp : list) {
			l.add(mp.Inf());
		}
		return l;
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
}
