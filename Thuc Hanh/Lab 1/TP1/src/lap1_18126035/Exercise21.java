//Viết chương trình nhập và ma trận A có n dòng và m cột.
//Thực hiện các yêu cầu sau:
//- Tìm giá trị max.
//- Tìm giá trị min. 
//- Nhập một giá trị k, xuất ra vị trí i và j của giá trị này trong ma trận, nếu không có thì
//return ra (-1, -1).

package lap1_18126035;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise21 {
	// hàm nhập 1 ma trận với rows là số dòng, cols là số cột của ma trận
	public static void Input(int[][] a, int rows, int cols) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print("a[" + i + "][" + j + "] = ");
				a[i][j] = sc.nextInt();
			}
		}
	}

	//hàm xuất ma trận với rows là số dòng, cols là số cột của ma trận
	public static void Output(int[][] a, int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(a[i][j] + "\t");

			}
			System.out.println();
		}
	}

	//hàm tìm giá trị max của matrix với rows là số dòng, cols là số cột của ma trận
	public static int Max(int[][] a, int rows, int cols) {
		int max = a[0][0];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (max < a[i][j])
					max = a[i][j];
			}

		}
		return max;
	}
	
	//hàm tìm giá trị min của matrix với rows là số dòng, cols là số cột của ma trận
	public static int Min(int[][] a, int rows, int cols) {
		int min = a[0][0];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (min > a[i][j])
					min = a[i][j];
			}

		}
		return min;
	}

	// key là giá trị k cần tìm trong matrix, rows là số dòng, cols là số cột của ma trận
	public static ArrayList Search(int[][] a, int rows, int cols, int key) {
		boolean flag = false;
		ArrayList<Integer> list = new ArrayList<Integer>(); // mảng chứa các position của key trong matrix (nếu có phần
															// tử = key)

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (a[i][j] == key) {

					list.add(i);
					list.add(j);
					flag = true;
				}
			}

		}
		if (flag == false) {
			ArrayList<Integer> listFail = new ArrayList<Integer>();
			listFail.add(-1);
			listFail.add(-1);
			// mảng listFail chứa cặp giá trị -1, -1
			return listFail;

		}
		// mảng list chứa các cặp giá trị vị trí xuất hiện của key
		// với vị trí i chẵn là vị trí dòng, i lẻ là vị trí cột, 2 vị trí i chẵn - lẻ
		// liên tiếp nhau là vị trí xuất hiện
		// vd: list = {1,2,2,3,4,3} nghĩa là key xuất hiện ở vị trí (1,2); (2,3); (4,3).
		return (list);
	}

	public static void main(String[] args) {
		System.out.print("Nhap so dong cua ma tran: ");
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();

		System.out.print("Nhap so cot cua ma tran: ");
		int cols = sc.nextInt();

		int[][] a = new int[rows][cols];
		Input(a, rows, cols);
		Output(a, rows, cols);

		System.out.println("\nMax cua ma tran: " + Max(a, rows, cols));
		System.out.println("Min cua ma tran: " + Min(a, rows, cols));

		System.out.print("\nNhap gia tri k can tim kiem: ");
		int key = sc.nextInt();

		ArrayList<Integer> list = Search(a, rows, cols, key);
		System.out.print(key + " xuat hien o vi tri: ");

		// mảng list chứa các cặp giá trị vị trí xuất hiện của key
		// với vị trí i chẵn là vị trí dòng, i lẻ là vị trí cột, 2 vị trí i chẵn - lẻ
		// liên tiếp nhau là vị trí xuất hiện
		// vd: list = {1,2,2,3,4,3} nghĩa là key xuất hiện ở vị trí (1,2); (2,3); (4,3).
		for (int i = 0; i < list.size(); i += 2) {

			System.out.print("(" + list.get(i) + (", " + list.get(i + 1) + ")\t"));
			// nếu list chứa {-1,-1} nghĩa là methode Search return về (-1,-1) => key ko tồn
			// tại trong matrix
			if (list.get(0) == -1 || list.get(1) == -1) {
				System.out.println("\nNghia la " + key + " khong ton tai trong matrix");
				break;
			}
		}

	}
}
