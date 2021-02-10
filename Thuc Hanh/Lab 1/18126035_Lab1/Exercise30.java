//Viet chuong trinh de tim ra chuoi dai nhat trong tu dien.
//Vi du 01: {"cat", "flag", "green", "country", "w3resource" } a Output: "w3resource"
//Vi du 02: {"cat", "dog", "red", "is"} -> Output: "cat", "dog", "red"


//package lap1_18126035;

import java.util.ArrayList;

public class Exercise30 {
	
	// ham xuat list (dung ArrayList)
	public static void Output(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {

			System.out.print(a.get(i) + "\t");

		}
	}

	// ham xuat mang array binh thuong
		public static void printArray(String[] a) {
			for (int i = 0; i < a.length; i++) {

				System.out.print(a[i] + "\t");

			}
		}
	
	
	// ham tra ve chuoi con dai nhat
	public static ArrayList<String> longestStrings(String[] a) {
		int maxLen = a[0].length();
		for (int i = 1; i < a.length; i++) {
			if (a[i].length() > maxLen)
				maxLen = a[i].length();
		}

		ArrayList<String> arrMaxLen = new ArrayList<String>();
		for (int i = 0; i < a.length; i++) {
			if (a[i].length() == maxLen)
				arrMaxLen.add(a[i]);

		}
		return arrMaxLen;
	}

	public static void main(String[] args) {
		String[] a = { "cat", "flag", "green", "country", "w3resource" };
		System.out.println("Mang ban dau: ");
		printArray(a);
		System.out.print("\nchuoi dai nhat trong mang: ");
		ArrayList list = longestStrings(a);
		Output(list);
		
		System.out.println();
		
		
		String[] b = {"cat", "dog", "red", "is"};
		System.out.println("\nMang ban dau: ");
		printArray(b);
		System.out.print("\nchuoi dai nhat trong mang: ");
		ArrayList list2 = longestStrings(b);
		Output(list2);

	}
}
