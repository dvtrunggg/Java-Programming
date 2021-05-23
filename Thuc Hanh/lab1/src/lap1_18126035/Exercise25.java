//Bài tập 25.
//Viết chương trình tìm vị trí của một giá trị trong một mảng đã được sắp xếp. Nêu không tìm
//thấy, thì insert giá trị này vào vị trí được sắp xếp trong mảng.
//Ví dụ:
//[1, 2, 4, 5, 6] -> 5 (target) -> 3 (index)
//[1, 2, 4, 5, 6] -> 0 (target) -> 0 (index)
//[1, 2, 4, 5, 6] -> 7 (target) -> 6 (indext)

package lap1_18126035;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise25 {

	// hàm search phần tử trong mảng, return về mảng các vị trí của key trong mảng
	public static ArrayList Search(int[] a, int key) {
		boolean flag = false;

		// mảng chứa các position của key (do key có thể xuất hiện > 1 lần ) trong array
		// (nếu có phần tử = key)
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			if (a[i] == key) {

				list.add(i);
				flag = true;
			}
		}
		return list;

	}

	// hàm xuất list (dùng ArrayList)
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

	// hàm check mảng đã dc sắp xếp tăng dần hay chưa
	public static boolean isSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			// nếu phần tử i+1 mà > phần tử i thì mảng ko tăng dần
			if (a[i] > a[i + 1])
				return false;
		}
		return true;
	}

	// hàm insert key vào mảng đã sắp xếp nếu key không tìm thấy
	// cách 1: dùng ArrayList
	public static ArrayList<Integer> Insert(int[] a, int key) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// gán các element từ a vào ArrayList
		for (Integer i : a) {
			list.add(i);
		}
		// gọi n =a. length
		// vì mảng truyền vào là mảng sắp xếp nên
		// nếu key > a[n-1] thì add key vào cuối mảng
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

	// cách 2: dùng hàm bình thường
	// insert key vào vị trị pos-1 (vị trí trước pos) của mảng
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

	// hàm insert key vào mảng đã sắp xếp nếu key không tìm thấy, return về newArr
	// đã insert
	public static int[] Inser_2(int arr[], int key) {

		// gọi n =a. length
		// vì mảng truyền vào là mảng sắp xếp nên
		// nếu key > a[n-1] thì add key vào cuối mảng
		int n = arr.length;
		int[] newArr = new int[n + 1];

		// hàm insert: insert key vào vị trị pos-1 (vị trí trước pos) của mảng
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

		// nếu mà mảng search có size > 0 => mảng có chứa key
		if (Search(a, key).size() > 0) {
			System.out.print(key + " o vi tri: ");
			Output(Search(a, key));
		} else {

			System.out.println(key + " Khong co trong mang, them " + key + " vao mang da sap xep");

			// cách 1
			ArrayList<Integer> newArr = Insert(a, key);
			Output(newArr);

//			// cách 2
//			int[] arr2 = Inser_2(a, key);
//			printArray(arr2);

		}

	}
}
