package Exercice4_18126035;

import java.util.ArrayList;
import java.util.Date;

public class Main extends Thread {

	public static void main(String[] args) throws InterruptedException {
		// TODO: Main thread
		myThread mtt1 = new myThread();
		Thread mainThread = new Thread(mtt1);
		mainThread.setName("Main Thread");
		mainThread.setPriority(MAX_PRIORITY);
		mainThread.start();
		mainThread.join();

		ArrayList<matrix> result;
		result = mtt1.getResult();

		for (int i = 0; i < result.size(); i++) {
			System.out.println("Ma tran thu " + (i + 1));
			result.get(i).xuat();
		}
		Date start = new Date();
		int[][] ketqua = new int[2][1];
		mtt1.multiply(result.get(0).getData(), result.get(1).getData(), ketqua);
		matrix ketquafinal = new matrix(2, 1);
		ketquafinal.setData(ketqua);
		System.out.println("Number of threads are used: " + mtt1.getNb_threads());
		System.out.println("Multiply result: ");
		ketquafinal.xuat();
		Date end = new Date();
		System.out.println("\nTime taken in milli seconds: " + (end.getTime() - start.getTime()));

	}

}
