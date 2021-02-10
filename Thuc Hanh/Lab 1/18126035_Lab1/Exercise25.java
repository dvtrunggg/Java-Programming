//Bai tap 25.
//Viet chuong trinh tim vi tri cua mot gia tri trong mot mang da duoc sap xep. Neu khong tim
//thay, thi insert gia tri nay vao vi tri duoc sap xep trong mang.
//Vi du:
//[1, 2, 4, 5, 6] -> 5 (target) -> 3 (index)
//[1, 2, 4, 5, 6] -> 0 (target) -> 0 (index)
//[1, 2, 4, 5, 6] -> 7 (target) -> 6 (indext)

//package lap1_18126035;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise25 {

	// ham search phan tu trong mang, return ve mang cac vi tri cua key trong mang
	public static ArrayList Search(int[] a, int key) {
		boolean flag = false;

		// mang chua cac position cua key (do key co the xuat hien > 1 lan ) trong array
		// (neu co phan tu = key)
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			if (a[i] == key) {

				list.add(i);
				flag = true;
			}
		}
		return list;

	}

	//  ham xuat list (dung ArrayList)
	public static void Output(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {

			System.out.print(a.get(i) + "\t");

		}
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {

			System.out.print(a[i] + "\t");

		}
	}

	// ham check mang da dc sap xep tang dan hay chua
	public static boolean isSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			// neu phan tu i+1 ma > phan tu i thi mang ko tang dan
			if (a[i] > a[i + 1])
				return false;
		}
		return true;
	}

	// ham insert key vao mang da sap xep neu key khong tim thay
	// cach 1: dung ArrayList
	public static ArrayList<Integer> Insert(int[] a, int key) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		//gan cac element tu a vao ArrayList
		for (Integer i : a) {
			list.add(i);
		}
		// goi n =a. length
		// vi mang truyen vao la mang sap xep nen
		// neu key > a[n-1] thi add key vao cuoi mang
		int n = list.size();
		if (key > list.get(n - 1))
			list.add(n, key);
		else if (key < list.get(0))
			list.add(0, key);
		else {
			for (int i = 1; i < n - 1; i++) {
				if (key > list.get(i) && key < list.get(i + 1))
					list.add(i + 1, key);
			}
		}
		return list;
	}

	// cach 2: dung ham binh thuong
	// insert key vao vi tri pos-1 (vi tri truoc pos) cua mang
	public static int[] insertX(int arr[], int key, int pos) {
		int n = arr.length;
		int newarr[] = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			if (i < pos - 1)
				newarr[i] = arr[i];
			else if (i == pos - 1)
				newarr[i] = key;
			else
				newarr[i] = arr[i - 1];
		}
		return newarr;
	}
	
	// ham insert key vao mang da sap xep neu key khong tim thay, return ve newArr
	// da insert
	public static int[] Inser_2(int arr[], int key) {

		// goi n =a. length
		// vi mang truyen vao la mang sap xep nen
		// neu key > a[n-1] thi add key vao cuoi mang
		int n = arr.length;
		int[] newArr = new int[n + 1];

		// ham insert: insert key vao vi tri pos-1 (vi tri truoc pos) cua mang
		if (key > arr[n - 1])
			newArr = insertX(arr, key, n + 1);
		else if (key < arr[0])
			newArr = insertX(arr, key, 1);
		else {
			for (int i = 1; i < n - 1; i++) {
				if (key > arr[i] && key < arr[i + 1])
					newArr = insertX(arr, key, i + 2);
			}
		}
		return newArr;
	}

	public static void main(String[] args) {
		int[] a = { -10, -4, -2, 5, 7, 8, 8, 10, 20 };
		ArrayList<Integer> list = Search(a, 2);
		printArray(a);
		// Output(list);
		if (!isSort(a)) {
			System.out.println("\nMang khong duoc sap xep!");
			System.exit(0);
		}

		System.out.print("\nNhap gia tri muon search: ");
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();

		// neu ma mang search co size > 0 => mang co chua key
		if (Search(a, key).size() > 0) {
			System.out.print(key + " o vi tri: ");
			Output(Search(a, key));
		} else {

			System.out.println(key + " Khong co trong mang, them " + key + " vao mang da sap xep");

			// cach 1
			ArrayList<Integer> newArr = Insert(a, key);
			Output(newArr);

//			// cach 2
//			int[] arr2 = Inser_2(a, key);
//			printArray(arr2);

		}

	}
}
