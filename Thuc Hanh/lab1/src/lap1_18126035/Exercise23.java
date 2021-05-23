//Bài 23
//Viết chương trình tìm mảng con liên tục có tổng giá trị lớn nhất trong mảng số nguyên.
//Ví dụ: cho -2, 1, -3, 4, -1, 2, 1, -5, 4 => 4, -1, 2, 1 có tổng là 6 là lớn nhất

package lap1_18126035;

import java.util.Vector;

public class Exercise23 {
	static Vector<Integer> SubarrayWithMaxSum(Vector<Integer> nums) {

		int end = 0, currMax = nums.get(0);
		int globalMax = nums.get(0);

		for (int i = 1; i < nums.size(); ++i) {

			// cập nhật lại currMax
			currMax = Math.max(nums.get(i), nums.get(i) + currMax);

			if (currMax > globalMax) {
				globalMax = currMax;
				end = i;
			}
		}

		int startIndex = end;

		// duyệt từ bên trái qua
		// tìm star index cho subarray
		while (startIndex >= 0) {
			globalMax -= nums.get(startIndex);

			if (globalMax == 0)
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
