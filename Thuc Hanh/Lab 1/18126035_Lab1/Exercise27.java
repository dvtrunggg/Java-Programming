//Bai tap 27.
//Viet chuong trinh de tim ra tat ca cac phan tu chi xuat hien 1 lan trong mang mot chieu cac so
//nguyen. Vi du: [10, 20, 30, 20, 50, 10, 40, 30] => Output: 50, 40

//package lap1_18126035;

import java.util.*;

public class Exercise27 {

	// // ham xuat list (dung ArrayList)
	public static void Output(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {

			System.out.print(a.get(i) + "\t");

		}
	}

	// ham xuat mang array binh thuon
	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {

			System.out.print(a[i] + "\t");

		}
	}

	// kiem tra bi trung o vi tri pos
	public static boolean isDuplicate(int a[], int pos) {
		for (int i = pos - 1; i >= 0; i--) {
			if (a[i] == a[pos])
				return false;
		}
		return true;
	}

	// dem so luong phan tu bi trung o vi tri pos
	public static int Duplicates(int a[], int pos) {
		int count = 1;
		int n = a.length;
		for (int i = pos + 1; i < n; i++) {
			if (a[i] == a[pos])
				count++;
		}
		return count;
	}

	// return ve mang cac phan tu chi xuat hien 1 lan
	public static ArrayList<Integer> occurrenceOnce(int a[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = a.length;
		for (int i = 0; i < n; i++) {
			boolean check = isDuplicate(a, i);
			if (check) {
				int count = Duplicates(a, i);
				if (count == 1) {
					list.add(a[i]);
				}
			}

		}
		return list;
	}

	public static void main(String[] args) {
		int[] a = { 10, 20, 30, 20, 50, 10, 40, 30 };
		System.out.println("Mang ban dau: ");
		printArray(a);
		
		System.out.println();
		
		System.out.println("\nCac phan tu chi xuat hien mot lan: ");
		ArrayList<Integer> list = occurrenceOnce(a);
		Output(list);
	}

}
