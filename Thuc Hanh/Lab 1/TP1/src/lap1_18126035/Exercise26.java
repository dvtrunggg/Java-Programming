//Bài tập 26.
//Viết chương trình tìm phần tử có giá trị giữa nhất trong một mảng chưa được sắp xếp.
//phần tử có giá trị giữa nhất là phần tử có giá trị gần bằng trung bình cộng của mảng nhất
//Ví dụ: [10, 2, 38, 23, 38, 23, 21] => Output: 23

package lap1_18126035;

import java.util.ArrayList;

public class Exercise26 {
	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {

			System.out.print(a[i] + "\t");

		}
	}

	// hàm tính trung bình cộng của các phần tử mảng
	public static double Average(int[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum / (a.length);
	}

	// hàm tìm min trong mảng ArrayList
	public static double Min(ArrayList<Double> a) {
		double min = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			if (a.get(i) < min)
				min = a.get(i);
		}
		return min;
	}

	// hàm tìm số gần với trung bình cộng nhất
	// hàm return về phần tử có giá trị gần bằng target nhất
	// lấy target - từng phần tử trong mảng và lưu vào mảng listMinus, tìm min của
	// mảng listMinus ->vị trí
	// từ vị trí -> phần tử gần với target nhất
	public static int Closest(int[] a, double target) {
		ArrayList<Double> listMinus = new ArrayList<Double>();

		for (int i : a) {
			double sub = (double) target - i;
			double temp = Math.abs(sub);
			listMinus.add(temp); // mảng chứa hiệu của target - phần tử mảng a
		}

		double min = Min(listMinus);
		int pos = listMinus.indexOf(min); // vị trí của min
		int closest = a[pos]; // vị trí của min trong listMinus là vị trí của phần tử gần target nhất
		return closest;
	}

	public static void main(String[] args) {
		int[] a = { 10, 2, 38, 23, 38, 23, 21 };

		printArray(a);
		double average = Average(a);
		System.out.println("\nAverage: " + average);
		System.out.println("Phan tu gan bang Average nhat (có giá trị giữa nhất): " + Closest(a, average));

	}

}
