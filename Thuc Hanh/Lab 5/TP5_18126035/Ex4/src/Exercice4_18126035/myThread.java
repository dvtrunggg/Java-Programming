package Exercice4_18126035;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class myThread implements Runnable {
	ArrayList<matrix> tempres = new ArrayList<>();
	private int[][] res;
	private int[][] matrix1;
	private int[][] matrix2;
	private int row;
	private int nb_threads;

	public int getNb_threads() {
		return nb_threads;
	}

	public myThread() {
	}

	public myThread(int[][] res, int[][] matrix1, int[][] matrix2, int row) {
		this.res = res;
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.row = row;
	}

	public ArrayList<matrix> getResult() {
		return this.tempres;
	}

	@Override

	public void run() {
		if (Thread.currentThread().getName() == "Main Thread") {
			System.out.println("Main thread is running......");
			try {
				File myObj = new File("input.txt");
				Scanner myReader = new Scanner(myObj);
				while (myReader.hasNextInt()) {
					matrix mt1 = new matrix();
					mt1.setSoDong(myReader.nextInt());
					mt1.setSoCot(myReader.nextInt());
					int data[][] = new int[mt1.getSoDong()][mt1.getSoCot()];
					for (int i = 0; i < mt1.getSoDong(); i++) {
						for (int j = 0; j < mt1.getSoCot(); j++) {
							data[i][j] = myReader.nextInt();
						}
					}
					mt1.setData(data);
					this.tempres.add(mt1);
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			matrix1 = tempres.get(0).getData();
			matrix2 = tempres.get(1).getData();

		} else {
			for (int i = 0; i < matrix2[0].length; i++) {
				res[row][i] = 0;
				for (int j = 0; j < matrix1[row].length; j++) {
					res[row][i] += matrix1[row][j] * matrix2[j][i];

				}
			}
		}
	}

	public void multiply(int[][] matrix1, int[][] matrix2, int[][] res) throws InterruptedException {
		ArrayList<Thread> threads = new ArrayList<>();
		int rows1 = matrix1.length;
		this.nb_threads = rows1;
		for (int i = 0; i < rows1; i++) {
			myThread task = new myThread(res, matrix1, matrix2, i);
			Thread thread = new Thread(task);
			thread.setName("Sub-Thread");
			thread.setPriority(Thread.NORM_PRIORITY);
			thread.start();
			threads.add(thread);
			for (int j = 0; j < threads.size(); j++) {
				try {
					System.out.println("Sub-thread terminated!!");
					threads.get(j).join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			threads.clear();
		}
	}

}
