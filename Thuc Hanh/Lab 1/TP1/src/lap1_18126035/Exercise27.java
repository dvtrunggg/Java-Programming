//Bài tập 27.
//Viết chương trình để tìm ra tất cả các phần tử chỉ xuất hiện 1 lần trong mảng một chiều các số
//nguyên. Ví dụ: [10, 20, 30, 20, 50, 10, 40, 30] => Output: 50, 40

package lap1_18126035;

import java.util.*;

public class Exercise27 {

	// hàm xuất list (dùng ArrayList)
	public static void Output(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {

			System.out.print(a.get(i) + "\t");

		}
	}

	// hàm xuất mảng array bình thường
	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {

			System.out.print(a[i] + "\t");

		}
	}

	// kiểm tra bị trùng ở vị trí pos
	public static boolean isDuplicate(int a[], int pos) {
		for (int i = pos - 1; i >= 0; i--) {
			if (a[i] == a[pos])
				return false;
		}
		return true;
	}

	// đếm số lượng phần tử bị trùng ở vị trí pos
	public static int Duplicates(int a[], int pos) {
		int count = 1;
		int n = a.length;
		for (int i = pos + 1; i < n; i++) {
			if (a[i] == a[pos])
				count++;
		}
		return count;
	}

	// return về mảng các phần tử chỉ xuất hiện 1 lần
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
