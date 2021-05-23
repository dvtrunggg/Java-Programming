//Bài tập 24.
//Viết chương trình tìm mảng con liên tục có tổng giá trị nhỏ nhất trong mảng số nguyên.

package lap1_18126035;

import java.util.Vector;

public class Exercise24 {
	static Vector<Integer> SubarrayWithMinSum(Vector<Integer> nums) {

		int end = 0, currMin = nums.get(0);
		int globalMin = nums.get(0);

		for (int i = 1; i < nums.size(); ++i) {

			// cập nhật lại currMin
			currMin = Math.min(nums.get(i), nums.get(i) + currMin);

			if (currMin < globalMin) {
				globalMin = currMin;
				end = i;
			}
		}

		int startIndex = end;

		// duyệt từ bên trái qua
		// tìm star index cho subarray
		while (startIndex >= 0) {
			globalMin -= nums.get(startIndex);

			if (globalMin == 0)
				break;

			// giảm start index
			startIndex--;
		}
		// add các phần tử của mảng con vào vector
		Vector<Integer> a = new Vector<Integer>();
		for (int i = startIndex; i <= end; ++i) {
			// System.out.print(nums.get(i) + " ");
			a.add(nums.get(i));
		}
		return a;
	}

	// output các element trong vector
	public static void Output(Vector<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + "\t");
		}
	}

	// tổng các phần tử trong vector
	public static int Sum(Vector<Integer> a) {
		int sum = 0;
		for (int i = 0; i < a.size(); i++) {
			sum += a.get(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		// arr ban đầu (array lớn)
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
