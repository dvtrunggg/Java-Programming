package Ex1_18126035;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import com.sun.source.tree.DoWhileLoopTree;

public class Exercise1 {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);

		ChiTietMay ct = new ChiTietMay();
		do {

			System.out.println("1.Nhap");
			System.out.println("2.Xuat");
			System.out.println("3.Tim tu ma");
			System.out.println("4.Tinh tien chi tiet don");
			System.out.println("5.Tinh tien chi tiet phuc");
			System.out.println("6.Xuat chi tiet may");
			System.out.println("7.Dem so luong chi tiet don");
			System.out.println("5.Ghi file");
			System.out.println("6.Doc file");

			System.out.println("Nhap lua chon: ");
			n = sc.nextInt();

			switch (n) {
			case 1:

				ct.Input();
				break;

			case 2:

				ct.Output();
				break;

			case 3:
				System.out.println("Nhap ma can tim: ");
				String str = sc.nextLine();
				for (ChiTiet ctt : ct.Search(str)) {
					ctt.Output();

				}
				break;

			case 4:
				System.out.println("Gia tien chi tiet don: " + ct.giaTienChiTietDon());
				break;

			case 5:
				System.out.println("Gia tien chi tiet phuc: " + ct.giaTienChiTietPhuc());
				break;

			case 6:
				ct.writeFile("ThongTinChiTietMay.data");
				break;

			case 7:
				ct.writeFile("ThongTinChiTiet.data");
				break;

			default:
				System.out.println("hello");
			}
		} while (n < 1 || n > 7);

	}

}
