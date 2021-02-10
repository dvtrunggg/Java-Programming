//Bai tap 24.
//Viet chuong trinh tim mang con lien tuc co tong gia tri nho nhat trong mang so nguyen.

//package lap1_18126035;

import java.util.Vector;

public class Exercise24 {
	static Vector<Integer> SubarrayWithMinSum(Vector<Integer> nums) {

		int end = 0, currMin = nums.get(0);
		int globalMin = nums.get(0);

		for (int i = 1; i < nums.size(); ++i) {

			// cap nhat lai currMin
			currMin = Math.min(nums.get(i), nums.get(i) + currMin);

			if (currMin < globalMin) {
				globalMin = currMin;
				end = i;
			}
		}

		int startIndex = end;

		// duyet tu ben trai qua
		// tim star index cho subarray
		while (startIndex >= 0) {
			globalMin -= nums.get(startIndex);

			if (globalMin == 0)
				break;

			// giam start index
			startIndex--;
		}
		// add cac phan tu cua mang con vao vector
		Vector<Integer> a = new Vector<Integer>();
		for (int i = startIndex; i <= end; ++i) {
			// System.out.print(nums.get(i) + " ");
			a.add(nums.get(i));
		}
		return a;
	}

	// output cac element trong vector
	public static void Output(Vector<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + "\t");
		}
	}

	// tong cac phan tu trong vector
	public static int Sum(Vector<Integer> a) {
		int sum = 0;
		for (int i = 0; i < a.size(); i++) {
			sum += a.get(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		// arr ban dau (array lon)
		Vector<Integer> arr = new Vector<Integer>();
		arr.add(-2);
		arr.add(1);
		arr.add(-3);
		arr.add(4);
		arr.add(-1);
		arr.add(2);
		arr.add(-1);
		arr.add(-5);
		arr.add(4);

		System.out.println("Array ban dau: ");
		Output(arr);

		Vector<Integer> subArr = SubarrayWithMinSum(arr);
		System.out.println("\nSub array co tong lon nhat: ");
		Output(subArr);
		System.out.println("\nSub array co tong = "+ Sum(subArr));
	}
}
