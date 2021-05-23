package test;

class Suduku{
	public int [][] a ;
	
	public Suduku() {
		a = new int [1][9];
		a = {1,2,3,4,5,6,7,8,9};
		
	}
}

public class ex3 {

	int size = 9;
	public static void print(int a[][], int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.println(a[i][j] + "\t");

			}
			System.out.println();
		}
	}
	
	public static boolean estX(int i; int j; int x) {
		
	}
	
	
	public static void main(String[] args) {
		
	}
}
