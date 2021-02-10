//Viet chuong trinh nhap va ma tran A co n dong va m cot.
//Thuc hien cac yeu cau sau:
//- Tim gia tri max.
//- Tim gia tri min. 
//- Nhap mot gia tri k, xuat ra vi tri i va j cua gia tri nay trong ma tran, neu khong co thi
//return ra (-1, -1).

//package lap1_18126035;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise21 {
	// ham nhap 1 ma tran voi rows la so dong, cols la so cot cua ma tran
	public static void Input(int[][] a, int rows, int cols) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print("a[" + i + "][" + j + "] = ");
				a[i][j] = sc.nextInt();
			}
		}
	}

	//ham xuat ma tran voi rows la so dong, cols la so cot cua ma tran
	public static void Output(int[][] a, int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(a[i][j] + "\t");

			}
			System.out.println();
		}
	}

	//ham tim gia tri max cua matrix voi rows la so dong, cols la so cot cua ma tran
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
	
	//ham tim gia tri min cua matrix voi rows la so dong, cols la so cot cua ma tran
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

	// key la gia tri k can tim trong matrix, rows la so dong, cols la so cot cua ma tran
	public static ArrayList Search(int[][] a, int rows, int cols, int key) {
		boolean flag = false;
		ArrayList<Integer> list = new ArrayList<Integer>(); // mang chua cac position cua key trong matrix (neu co phan tu = key)
															

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
			// mang listFail chua cap gia tri -1, -1
			return listFail;

		}
		// mang list chua cac cap gia tri vi tri xuat hien cua key
		// voi vi tri i chan la vi tri dong, i le la vi tri cot, 2 vi tri i chan - le
		// lien tiep nhau la vi tri xuat hien
		// vd: list = {1,2,2,3,4,3} nghia la key xuat hien o vi tri (1,2); (2,3); (4,3).
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

		// mang list chua cac cap gia tri vi tri xuat hien cua key
		// voi vi tri i chan la vi tri dong, i le la vi tri cot, 2 vi tri i chan - le
		// lien tiep nhau la vi tri xuat hien
		// vd: list = {1,2,2,3,4,3} nghia la key xuat hien o vi tri (1,2); (2,3); (4,3).
		for (int i = 0; i < list.size(); i += 2) {

			System.out.print("(" + list.get(i) + (", " + list.get(i + 1) + ")\t"));
			// neu list chua {-1,-1} nghia la methode Search return ve (-1,-1) => key ko ton
			// tai trong matrix
			if (list.get(0) == -1 || list.get(1) == -1) {
				System.out.println("\nNghia la " + key + " khong ton tai trong matrix");
				break;
			}
		}

	}
}
