package lab2_18126035;

import java.util.Scanner;

public class MangHaiChieu {
	private int[][] arr;

	public MangHaiChieu(String s) {
		arr = parseMangHaiChieu(s);
	}

	public MangHaiChieu() {
		this.Input();
	}

	public MangHaiChieu(int[][] arr) {
		this.arr = arr;
	}

	public int[][] getArr() {
		return arr;
	}

	public void setArr(int[][] arr) {
		this.arr = arr;
	}

	public void Input() {
		int rows, cols;
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhap so dong: ");
		rows = Integer.parseInt(sc.nextLine());
		System.out.print("Nhap so cot: ");
		cols = Integer.parseInt(sc.nextLine());

		arr = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print("arr [" + i + ", " + j + "]: ");
				arr[i][j] = Integer.parseInt(sc.nextLine());
			}
		}
	}

	public void Output() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void sortAscRow() {
		// bubble sort

		// loop for rows of arrrix
		for (int i = 0; i < arr.length; i++) {
			// loop for column of arrrix
			for (int j = 0; j < arr[i].length; j++) {
				// loop for comparison and swapping
				for (int k = 0; k < arr[i].length - j - 1; k++) {
					if (arr[i][k] > arr[i][k + 1]) {
						// swapping of elements
						int t = arr[i][k];
						arr[i][k] = arr[i][k + 1];
						arr[i][k + 1] = t;
					}
				}
			}
		}

	}

	public void sortDescCol() {
		for (int i = 0; i < arr[0].length; i++) { // so cot
			for (int j = 0; j < arr.length; j++) { // so dong
				for (int k = 0; k < arr.length - j - 1; k++) {
					if (arr[k][i] < arr[k + 1][i]) {
						// swapping of elements
						int t = arr[k][i];
						arr[k][i] = arr[k + 1][i];
						arr[k + 1][i] = t;
					}
				}
			}
		}

	}

	public int sum() {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}

	public int multiplication() {
		int mul = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				mul = mul * arr[i][j];
			}
		}
		return mul;
	}

	public int findMax() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (max < arr[i][j]) {
					max = arr[i][j];
				}
			}
		}
		return max;
	}

	// tim so nguyen duong nho nhat
	public int findMinPositive() {
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > 0 && arr[i][j] < res) {
					res = arr[i][j];
				}
			}
		}
		return res;
	}

	public int findMaxNegative() {
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] < 0 && arr[i][j] > res) {
					res = arr[i][j];
				}
			}
		}
		return res;
	}

	public int findMaxRow() {
		int maxRow = 0;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}

			if (max < sum) {
				max = sum;
				maxRow = i;
			}
			sum = 0;
		}
		return maxRow;
	}

	public int findMaxCol() {
		int maxCol = 0;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				sum += arr[j][i];
			}

			if (max < sum) {
				max = sum;
				maxCol = i;
			}
			sum = 0;
		}

		return maxCol;
	}

	public void addRowFirst() {
		Scanner sc = new Scanner(System.in);

		int rows = arr.length + 1;
		int cols = arr[0].length;
		int[][] a = new int[rows][cols];

		System.out.println("Nhap dong can them: ");
		for (int i = 0; i < cols; i++) {
			System.out.print("arr[0][" + i + "] : ");
			a[0][i] = Integer.parseInt(sc.nextLine());
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				a[i][j] = arr[i - 1][j];
			}
		}

		this.setArr(a);

	}

	public void addRowLast() {
		Scanner scanner = new Scanner(System.in);

		int rows = arr.length;
		int cols = arr[0].length;
		int[][] a = new int[rows + 1][cols];

		System.out.println("Nhap dong can them: ");
		for (int i = 0; i < cols; i++) {
			System.out.print("arr[" + rows + "][" + i + "] :");
			a[rows][i] = Integer.parseInt(scanner.nextLine());
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				a[i][j] = arr[i][j];
			}
		}

		this.setArr(a);

	}

	public void addRowPosition(int k) {
		if (k < 0 || k >= arr.length)
			return;

		Scanner sc = new Scanner(System.in);

		int rows = arr.length;
		int cols = arr[0].length;
		int[][] a = new int[rows + 1][cols];

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < cols; j++) {
				a[i][j] = arr[i][j];
			}
		}

		System.out.println("Nhap dong can them: ");
		for (int i = 0; i < cols; i++) {
			System.out.print("arr[" + k + "][" + i + "] :");
			a[k][i] = Integer.parseInt(sc.nextLine());
		}

		for (int i = k + 1; i < rows + 1; i++) {
			for (int j = 0; j < cols; j++) {
				a[i][j] = arr[i - 1][j];
			}
		}

		this.setArr(a);

	}

	// xoa dong thu k
	public void removeRow(int k) {
		if (k < 0 || k >= arr.length)
			return;

		Scanner scanner = new Scanner(System.in);

		int rows = arr.length;
		int cols = arr[0].length;
		int[][] a = new int[rows - 1][cols];

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < cols; j++) {
				a[i][j] = arr[i][j];
			}
		}

		for (int i = k; i < rows - 1; i++) {
			for (int j = 0; j < cols; j++) {
				a[i][j] = arr[i + 1][j];
			}
		}

		this.setArr(a);

	}

	// xoa cot thu k
	public void removeCol(int k) {
		if (k < 0 || k >= arr[0].length)
			return;

		Scanner scanner = new Scanner(System.in);

		int rows = arr.length;
		int cols = arr[0].length;
		int[][] a = new int[rows][cols - 1];

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < rows; j++) {
				a[j][i] = arr[j][i];
			}
		}

		for (int i = k; i < cols - 1; i++) {
			for (int j = 0; j < rows; j++) {
				a[j][i] = arr[j][i + 1];
			}
		}

		this.setArr(a);

	}

	// chuyen chuoi thanh mang 2 chieu ki tư space
	public static int[][] parseMangHaiChieu(String s) {
		String[] rowTemp= s.split(",");
		String[] elements = rowTemp[0].split(" ");

		int rows = rowTemp.length;
		int cols = elements.length;

		int[][] a = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			elements = rowTemp[i].split(" ");
			for (int j = 0; j < cols; j++) {
				System.out.println(elements[j]);
				a[i][j] = Integer.parseInt(elements[j]);
			}
		}
		return a;
	}
}
