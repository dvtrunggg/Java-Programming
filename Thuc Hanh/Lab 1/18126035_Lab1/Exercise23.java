//Bai 23
//Viet chuong trinh tim mang con lien tuc co tong gia tri lon nhat trong mang so nguyen.
//Vi du: cho -2, 1, -3, 4, -1, 2, 1, -5, 4 => 4, -1, 2, 1 co tong la 6 la lon nhat

//package lap1_18126035;

import java.util.Vector;

public class Exercise23 {
	static Vector<Integer> SubarrayWithMaxSum(Vector<Integer> nums) {

		int end = 0, currMax = nums.get(0);
		int globalMax = nums.get(0);

		for (int i = 1; i < nums.size(); ++i) {

			// cap nhat lai currMax
			currMax = Math.max(nums.get(i), nums.get(i) + currMax);

			if (currMax > globalMax) {
				globalMax = currMax;
				end = i;
			}
		}

		int startIndex = end;

		// duyet tu ben trai qua
		// tim star index cho subarray
		while (startIndex >= 0) {
			globalMax -= nums.get(startIndex);

			if (globalMax == 0)
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
		arr.add(1);
		arr.add(-5);
		arr.add(4);

		System.out.println("Array ban dau: ");
		Output(arr);

		Vector<Integer> subArr = SubarrayWithMaxSum(arr);
		System.out.println("\nSub array co tong lon nhat: ");
		Output(subArr);
		System.out.println("\nSub array co tong = "+ Sum(subArr));

	}

}
