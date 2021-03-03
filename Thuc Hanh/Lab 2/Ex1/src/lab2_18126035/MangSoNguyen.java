package lab2_18126035;

import java.util.ArrayList;
import java.util.Scanner;

public class MangSoNguyen {
	private int a[];
	private int len;

	public MangSoNguyen() {
		this.len = 0;
		this.a = null;
	}

	public MangSoNguyen(int len) {
		this.len = len;
	}

	public int[] getA() {
		return a;
	}

	public void setA(int[] a) {
		this.a = a;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);
		// neu mang a chua dc khoi tao
		if (this.len <= 0) {
			System.out.print("Enter length of array: ");
			this.len = sc.nextInt();
		}

		a = new int[len];
		for (int i = 0; i < len; i++) {
			System.out.print("a[" + i + "] = ");
			this.a[i] = sc.nextInt();
		}
	}

	public void Output() {
		for (int i = 0; i < len; i++) {
			System.out.print(a[i]);
			System.out.print("\t");
		}
		System.out.println();
	}

	// using selection sort
	public void acsendingSort() {
		for (int i = 0; i < len - 1; i++) {

			int min_idx = i;
			for (int j = i + 1; j < len; j++)
				if (a[j] < a[min_idx])
					min_idx = j;

			// Swap
			int temp = a[min_idx];
			a[min_idx] = a[i];
			a[i] = temp;
		}
	}

	public void decsendingSort() {
		for (int i = 0; i < len - 1; i++) {

			int max_idx = i;
			for (int j = i + 1; j < len; j++)
				if (a[j] > a[max_idx])
					max_idx = j;

			// Swap
			int temp = a[max_idx];
			a[max_idx] = a[i];
			a[i] = temp;
		}
	}

	// sum of element in array
	public int Sum() {
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += a[i];
		}
		return sum;
	}

	// Tich of element in array :)))
	public int Multiplication() {
		int mul = 1;
		for (int i = 0; i < len; i++) {
			mul *= a[i];
		}
		return mul;
	}

	// largest element in array
	public int Max() {
		int max = a[0];
		for (int i = 1; i < len; i++) {
			if (max < a[i])
				max = a[i];
		}

		return max;
	}

	// largest negative element in array
	public int maxNegative() {
		int max = 1;

		for (int i = 0; i < len; i++) {
			if (a[i] < 0) {
				max = a[i];
				break;
			}
		}

		for (int i = 0; i < len; i++) {
			if (max < a[i] && a[i] < 0)
				max = a[i];
		}

		return max;
	}

	// smaillest possitive element in array
	public int minPosstive() {
		int min = -1;

		for (int i = 0; i < len; i++) {
			if (a[i] > 0) {
				min = a[i];
				break;
			}
		}

		for (int i = 0; i < len; i++) {
			if (min > a[i] && a[i] > 0)
				min = a[i];
		}

		return min;
	}

	// them phan tu vao vi tri pos
	public void addPostion(int value, int pos) {
		if (pos > len || pos < 0) {
			System.out.println("Postion must be <= len or >= 0 (0 <= pos <= len)");
			System.exit(0);
		}

		if (pos == 0)
			addHead(value);
		else if (pos == len)
			addTail(value);

		else {
			int newArr[] = new int[len + 1];
//			for (int i = 0; i < pos; i++) {
//				newArr[i] = a[i];
//			}
//
//			newArr[pos] = value;
//
//			for (int i = pos + 1; i < len; i++) {
//				newArr[i] = a[i - 1];
//			}

			for (int i = 0; i < len + 1; i++) {
				if (i < pos)
					newArr[i] = a[i];
				else if (i == pos)
					newArr[i] = value;
				else
					newArr[i] = a[i - 1];
			}

			setLen(len + 1);
			setA(newArr);
		}

	}

	// them phan tu vao dau mang
	public void addHead(int value) {
		int newArr[] = new int[len + 1];
		newArr[0] = value;
		for (int i = 0; i < len; i++) {
			newArr[i + 1] = a[i];
		}
		setLen(len + 1);
		setA(newArr);
	}

	// them phan tu vao cuoi mang
	public void addTail(int value) {
		int newArr[] = new int[len + 1];

		for (int i = 0; i < len; i++) {
			newArr[i] = a[i];
		}
		newArr[len] = value;
		setLen(len + 1);
		setA(newArr);
	}

	// xoa phan tu tai vi tri k
	public void deletePostion(int pos) {
		if (pos > len || pos < 0) {
			System.out.println("Postion must be <= len or >= 0 (0 <= pos <= len)");
			System.exit(0);
		}

		int newArr[] = new int[len - 1];
		int i, k = 0;
		for (i = 0; i < len; i++) {
			if (i == pos)
				continue;
			newArr[k++] = a[i];

		}
		setLen(len - 1);
		setA(newArr);
	}

	// xoa phan tu value
	public void deleteElement(int value) {
		ArrayList<Integer> listPos = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			if (a[i] == value)
				listPos.add(i);
		}

		// listPos chua cac vi tri cua value
		for (int i = listPos.size() - 1; i >= 0; i--) {
			deletePostion(listPos.get(i));

		}
	}

	// cap nhat cac phan tu tai vi tri pos
	public void Update(int value, int pos) {
		if (pos > len || pos < 0) {
			System.out.println("Postion must be <= len or >= 0 (0 <= pos <= len)");
			System.exit(0);
		}

		for (int i = 0; i < len; i++) {
			a[pos] = value;
		}
	}

	// cap nhat phan tu co gia tri x thanh y
	public void updateValue(int x, int y) {
		int pos = -1;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			if (a[i] == x) {
				list.add(i);
			}
		}

		if (list.size() == 0)
			System.out.println(x + " is not in array");
		else {
			for (int i = 0; i < list.size(); i++) {
				a[list.get(i)] = y;
			}
		}

	}

	public int[] parseMangSoNguyen(String str) {
		String[] b = str.split("[,; ]+");

		int arr[] = new int[b.length];
		int j = 0;
		for (String i : b) {
			arr[j] = Integer.parseInt(i);
			j++;
		}
		return arr;
	}
}
