//Bai tap 26.
//Viet chuong trinh tim phan tu co gia tri giua nhat trong mot mang chua duoc sap xep.
//phan tu co gia tri giua nhat la phan tu co gia tri gan bang trung binh cong cua mang nhat
//Vi du: [10, 2, 38, 23, 38, 23, 21] => Output: 23

//package lap1_18126035;

import java.util.ArrayList;

public class Exercise26 {
	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {

			System.out.print(a[i] + "\t");

		}
	}

	// ham tinh trung binh cong cua cac phan tu mang
	public static double Average(int[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum / (a.length);
	}

	//ham tim min trong mang ArrayList
	public static double Min(ArrayList<Double> a) {
		double min = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			if (a.get(i) < min)
				min = a.get(i);
		}
		return min;
	}

	// ham tim so gan voi trung binh cong nhat
	// ham return ve phan tu co gia tri gan bang target nhat
	// lay target - tung phan tu trong mang va luu vao mang listMinus, tim min cua
	// mang listMinus ->vi tri
	// tu vi tri -> phan tu gan voi target nhat
	public static int Closest(int[] a, double target) {
		ArrayList<Double> listMinus = new ArrayList<Double>();

		for (int i : a) {
			double sub = (double) target - i;
			double temp = Math.abs(sub);
			listMinus.add(temp); // mang chua hieu cua target - phan tu mang a
		}

		double min = Min(listMinus);
		int pos = listMinus.indexOf(min); // vi tri cua min
		int closest = a[pos]; //vi tri cua min trong listMinus la vi tri cua phan tu gan target nhat
		return closest;
	}

	public static void main(String[] args) {
		int[] a = { 10, 2, 38, 23, 38, 23, 21 };

		printArray(a);
		double average = Average(a);
		System.out.println("\nAverage: " + average);
		System.out.println("Phan tu gan bang Average nhat (co gia tri gan giua nhat): " + Closest(a, average));

	}

}
