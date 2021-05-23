package Exercise4_18126035;

import java.util.ArrayList;

public class Mythread implements Runnable {
	private Thread thrd;
	private int a[][];
	private int b[][];
	int row1, row2, col1, col2;
	private int[] listA;
	private int[] listB;
	private ArrayList<Integer> listResult;
	int[][] product;

	public Mythread(int[][] a, int[][] b, int[] listA, int[] listB, String name, int row1, int row2, int col1,
			int col2) {

		this.thrd = new Thread(this, name);
		this.a = a;
		this.b = b;
		this.listA = listA;
		this.listB = listB;
		this.row1 = row1;
		this.row2 = row2;
		this.col1 = col1;
		this.col2 = col2;
	}

	public Mythread(String name, int[][] a, int[][] b, int row1, int row2, int col1, int col2, int[][] product) {
		this.thrd = new Thread(this, name);
		this.a = a;
		this.b = b;
		this.row1 = row1;
		this.row2 = row2;
		this.col1 = col1;
		this.col2 = col2;
		product = new int[row1][col2];
	}

	public void mul2Matrix() {
		try {

			listResult = new ArrayList<>();
			Thread.sleep(0);
			int temp[] = new int[listA.length];
			for (int i = 0; i < listA.length; i++) {
				temp[i] = listA[i] * listB[i];
			}

			int sum = 0;
			for (int i = 0; i < temp.length; i++) {
				sum += temp[i];
			}
			listResult.add(sum);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrupted");

		}
	}

	public void Mul() {
		product = new int[row1][col2];

		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < col2; j++) {
				for (int k = 0; k < col1; k++) {
					product[i][j] += a[i][k] * b[k][j];
				}
			}
		}

	}

	public static void Output(int a[][], int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void run() {
		// mul2Matrix();

		try {
			Thread.sleep(10);
			Mul();
			//Output(product, row1, col1);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrupted");
		}
	}

	public Thread getThrd() {
		return thrd;
	}

	public void setThrd(Thread thrd) {
		this.thrd = thrd;
	}

	public int[][] getA() {
		return a;
	}

	public void setA(int[][] a) {
		this.a = a;
	}

	public int[][] getB() {
		return b;
	}

	public void setB(int[][] b) {
		this.b = b;
	}

	public int[] getListA() {
		return listA;
	}

	public void setListA(int[] listA) {
		this.listA = listA;
	}

	public int[] getListB() {
		return listB;
	}

	public void setListB(int[] listB) {
		this.listB = listB;
	}

	public ArrayList<Integer> getListResult() {
		return listResult;
	}

	public void setListResult(ArrayList<Integer> listResult) {
		this.listResult = listResult;
	}

	public int[][] getProduct() {
		return product;
	}

	public void setProduct(int[][] product) {
		this.product = product;
	}
	

}
