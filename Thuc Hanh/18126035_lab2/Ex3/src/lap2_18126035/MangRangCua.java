package lap2_18126035;

import java.util.ArrayList;
import java.util.Scanner;

public class MangRangCua {
	private int a[][];
	private int rows;

	public MangRangCua() {
		this.rows = 0;
		// this.a = null;
	}

	public MangRangCua(int a[][]) {
		this.a = a;
	}

	public MangRangCua(int rows) {
		this.rows = rows;
	}

	public int[][] getA() {
		return a;
	}

	public void setA(int[][] b) {
		this.a = b;
		this.rows = b.length;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);
		if (rows <= 0) {
			System.out.print("Nhap so luong dong: ");
			rows = sc.nextInt();
		}
		a = new int[rows][];

		for (int i = 0; i < rows; i++) {
			System.out.print("So luong phan tu a[" + i + "]: ");
			int size = sc.nextInt();
			a[i] = new int[size];
		}

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a[i].length; j++) {
				System.out.print("a[" + i + "][" + j + "] = ");
				a[i][j] = sc.nextInt();
			}
		}

	}

	public void Output() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void selectionSort() {
		for (int k = 0; k < rows; k++) {
			for (int i = 0; i < a[k].length - 1; i++) {

				int min_idx = i;
				for (int j = i + 1; j < a[k].length; j++)
					if (a[k][j] < a[k][min_idx])
						min_idx = j;

				// Swap
				int temp = a[k][min_idx];
				a[k][min_idx] = a[k][i];
				a[k][i] = temp;
			}
		}
	}

	public int Sum() {
		int sum = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < a[i].length; j++) {
				sum += a[i][j];
			}

		}
		return sum;
	}

	public int Multiplication() {
		int mul = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < a[i].length; j++) {
				mul *= a[i][j];
			}

		}
		return mul;
	}

	// largest element in jagged array
	public int Max() {
		int max = a[0][0];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (max < a[i][j])
					max = a[i][j];
			}

		}

		return max;
	}

	// largest negative element in jagged array
	public int maxNegative() {
		int max = 1;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] < 0) {
					max = a[i][j];
					break;
				}
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (max < a[i][j] && a[i][j] < 0)
					max = a[i][j];
			}

		}
		return max;
	}

	// smallest possitive element in jagged array
	public int minPosstive() {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (min > a[i][j] && a[i][j] > 0)
					min = a[i][j];
			}
		}

		return min;
	}

	public int findMaxRow() {
		int maxRow = 0;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < a[i].length; j++) {
				sum += a[i][j];
			}

			if (max < sum) {
				max = sum;
				maxRow = i;
			}
			sum = 0;
		}
		return maxRow;
	}

	public void addRowFirst() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so phan tu cua dong: ");
		int size = sc.nextInt(); // size of new line adding

		int arrTemp[][] = new int[rows + 1][];

		arrTemp[0] = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.print("Nhap phan tu a'[0][" + i + "] :");
			arrTemp[0][i] = sc.nextInt();
		}

		for (int i = 0; i < rows; i++) {
			arrTemp[i + 1] = new int[a[i].length];
			for (int j = 0; j < a[i].length; j++) {
				arrTemp[i + 1][j] = a[i][j];
			}
		}

		this.setRows(rows + 1);
		this.setA(arrTemp);

	}

	public void addRowLast() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so phan tu cua dong: ");
		int size = sc.nextInt(); // size of new line adding

		int arrTemp[][] = new int[rows + 1][];
		for (int i = 0; i < rows; i++) {
			arrTemp[i] = new int[a[i].length];
			for (int j = 0; j < a[i].length; j++) {
				arrTemp[i][j] = a[i][j];
			}
		}

		arrTemp[rows] = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.print("Nhap phan tu a'[" + (rows + 1) + "][" + i + "] :");
			arrTemp[rows][i] = sc.nextInt();
		}

		this.setRows(rows + 1);
		this.setA(arrTemp);

	}

	// lay size cua moi dong trong jagged array
	public void getSizeRow() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			list.add(a[i].length);
			System.out.println(list.get(i));
		}

	}

	public void addRowPosition(int pos) {
		if (pos < 0 || pos >= a.length)
			return;

		if (pos == 0)
			this.addRowFirst();
		else if (pos == rows)
			this.addRowLast();
		else {
			Scanner sc = new Scanner(System.in);

			System.out.print("Nhap so phan tu cua dong: ");
			int size = sc.nextInt(); // size of new line adding

			int arrTemp[][] = new int[rows + 1][];

			for (int i = 0; i < pos; i++) {
				arrTemp[i] = new int[a[i].length];

				for (int j = 0; j < a[i].length; j++) {
					arrTemp[i][j] = a[i][j];
				}
			}

			arrTemp[pos] = new int[size];
			for (int i = 0; i < size; i++) {
				System.out.print("Nhap phan tu a'[" + pos + "][" + i + "] :");
				arrTemp[pos][i] = sc.nextInt();
			}

			for (int i = pos + 1; i < arrTemp.length; i++) {
				arrTemp[i] = new int[a[i - 1].length];
				for (int j = 0; j < a[i - 1].length; j++) {
					arrTemp[i][j] = a[i - 1][j];
				}
			}

			this.setRows(rows + 1);
			this.setA(arrTemp);

		}
	}

	public void deleteRowPos(int pos) {
		if (pos < 0 || pos >= a.length)
			return;

		Scanner sc = new Scanner(System.in);

		int arrTemp[][] = new int[rows - 1][];

		for (int i = 0; i < pos; i++) {
			arrTemp[i] = new int[a[i].length];
			for (int j = 0; j < a[i].length; j++) {
				arrTemp[i][j] = a[i][j];
			}
		}

		for (int i = pos + 1; i < rows; i++) {
			arrTemp[i - 1] = new int[a[i].length];
			for (int j = 0; j < a[i].length; j++) {
				arrTemp[i - 1][j] = a[i][j];
			}
		}

		this.setRows(rows - 1);
		this.setA(arrTemp);

	}

	public void deletePostion(int arr[], int pos) {
		if (pos > arr.length || pos < 0) {
			return;
		}

		int newArr[] = new int[arr.length - 1];
		int i, k = 0;
		for (i = 0; i < arr.length; i++) {
			if (i == pos)
				continue;
			newArr[k++] = arr[i];

		}

	}

	public void deleteColPos(int pos) {
		// tim phan tu thuoc cot lon nhat

		int maxIndex = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (maxIndex < j)
					maxIndex = j;
			}
		}

		if (pos < 0 || pos >= maxIndex)
			return;

		int arrTemp[][] = new int[rows][];
		for (int i = 0; i < rows; i++) {

			if (pos >= a[i].length) {
				arrTemp[i] = new int[a[i].length];
				continue;
			}

			arrTemp[i] = new int[a[i].length - 1];

			for (int j = 0; j < pos; j++) {
				arrTemp[i][j] = a[i][j];
			}
			for (int j = pos + 1; j < a[i].length; j++) {
				arrTemp[i][j - 1] = a[i][j];

			}

		}

		setA(arrTemp);

	}
	public int[] parseeMangRangCuaHaiChieu(String str) {
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
