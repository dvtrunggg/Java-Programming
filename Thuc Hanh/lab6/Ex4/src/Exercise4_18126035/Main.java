package Exercise4_18126035;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	// read data from file
	public static ArrayList<String> readFile(String path) {
		ArrayList<String> data = new ArrayList<>();

		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();
			while (line != null) {
				if (line.length() > 0)
					data.add(line);
				line = br.readLine();
			}

			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	
	// write data to file
	public static void writeFile(ArrayList<Integer> data, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);

//			for (String dt : data) {
//				bw.write(dt);
//				bw.newLine();
//			}

			for (int i = 0; i < data.size(); i++) {
				bw.write(data.get(i).toString());
				if (i < data.size() - 1)
					bw.write(", ");

				// bw.newLine();
			}
			bw.newLine();
			bw.close();
			osw.close();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void getMatrix(ArrayList<String> data, int rows, int cols, int matrix[][]) {

		// matrix A
		ArrayList<String> matrixA_Str = new ArrayList<>();
		for (int i = 1; i <= rows; i++) {
			matrixA_Str.add(data.get(i));
		}

		for (int i = 0; i < matrixA_Str.size(); i++) {
			String temp[] = matrixA_Str.get(i).split("\t");
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
			}
		}
	}

	public static int[] getColumn(int[][] array, int index) {
		int[] column = new int[array[0].length];
		for (int i = 0; i < column.length; i++) {
			column[i] = array[i][index];
		}
		return column;
	}

	public static void main(String[] args) throws InterruptedException {
		ArrayList<String> data = readFile("data.txt");

		// line 1 is number of rows and columns of matrix a
		String[] inf_A = data.get(0).split("\t");
		int rowsA = Integer.parseInt(inf_A[0]);
		int colsA = Integer.parseInt(inf_A[1]);

		int matrixA[][] = new int[rowsA][colsA];
		getMatrix(data, rowsA, colsA, matrixA);
		// Output(matrixA, rowsA, colsA);

		// number of rows and columns of matrix B
		String[] inf_B = data.get(rowsA + 1).split("\t");
		int rowsB = Integer.parseInt(inf_B[0]);
		int colsB = Integer.parseInt(inf_B[1]);

		int matrixB[][] = new int[rowsB][colsB];
		getMatrix(data, rowsB, colsB, matrixB);

		// Output(matrixB, rowsB, colsB);

//		int a[] = getColumn(matrixA, 0);
//		for (int i : matrixA[0]) {
//			System.out.println(i);
//		}

		if (colsA != rowsB) {
			System.out.println("number of columns matrix A have to = number of rows matrix B");
			return;
		}

//		ArrayList<Mythread> list = new ArrayList<>();
//		for (int i = 0; i < colsA; i++) {
//			Mythread td = new Mythread(matrixA, matrixB, matrixA[i], getColumn(matrixB, i), "Thread" + i);
//			list.add(td);
//		}
//		
//		for(int i = 0; i<list.size();i++)
//		{
//			list.get(i).getThrd().start();
//		}

		int res[][] = new int[rowsA][colsB];
		Mythread td = new Mythread("Thread", matrixA, matrixB, rowsA, rowsB, colsA, colsB, res);
		td.getThrd().start();
		
		td.getThrd().join();
		Mythread.Output(td.getProduct(), rowsA, colsB);
		
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(rowsA);
		temp.add(colsB);
		
		

	}
}
