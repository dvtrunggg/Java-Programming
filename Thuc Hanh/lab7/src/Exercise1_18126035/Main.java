package Exercise1_18126035;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

	// create random a array
	public static ArrayList<Integer> createRandomList(int n) {

		ArrayList<Integer> list = new ArrayList<>();
		Random rand = new Random();

		int max = 100000;
		int min = -1000000;

		for (int i = 0; i < n; i++) {
			int value = (int) ((Math.random() * (max - min)) + min);
			list.add(value);
		}
		return list;
	}

	// write data to file
	public static void writeFile(ArrayList<Integer> data, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);

			for (int i = 0; i < data.size(); i++) {
				bw.write(data.get(i).toString());
				if (i < data.size() - 1) {
					bw.write(" ");
					// bw.newLine();
				}

				// bw.newLine();
			}
			bw.newLine();
			bw.close();
			osw.close();
			fos.close();

		} catch (IOException io) {
			System.out.println("IOException found :" + io.getMessage());
		} catch (Exception e) {
			System.out.println("Something wrong: " + e.getMessage());
		}

	}

//	// read data from file
//	public static ArrayList<String> readFile(String path) {
//		ArrayList<String> data = new ArrayList<>();
//
//		try {
//			FileInputStream fis = new FileInputStream(path);
//			InputStreamReader isr = new InputStreamReader(fis);
//			BufferedReader br = new BufferedReader(isr);
//
//			String line = br.readLine();
//			while (line != null) {
//				if (line.length() > 0)
//					data.add(line);
//				line = br.readLine();
//			}
//
//			br.close();
//			isr.close();
//			fis.close();
//		} catch (IOException io) {
//			System.out.println("IOException found :" + io.getMessage());
//		} catch (Exception e) {
//			System.out.println("Something wrong: " + e.getMessage());
//			return;
//		}
//		return data;
//	}

	// read data from file
	public static boolean readFile(ArrayList<String> data, String path) {
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
			return true;
		} catch (IOException io) {
			System.out.println("IOException found :" + io.getMessage());
		} catch (Exception e) {
			System.out.println("Something wrong: " + e.getMessage());
		}
		return false;

	}

	// sum of array
	public static long sumArray(ArrayList<Integer> list) {
		long sum = 0;
		for (Integer i : list) {
			sum += i;
		}
		return sum;
	}

	/**
	 * 
	 * @param listThread: list of threads
	 * @param dataInt:    list of numbres from reading file input
	 * @param start:      the first element in list data when generate a thread
	 * @param end:        the last element in list data when generate a thread
	 * @param n:          the number of threads
	 */
	public static void listThreadExecute(ArrayList<MyThread> listThread, ArrayList<Integer> dataInt, int start, int end,
			int n) {

		int step = (end - start) / n;

		for (int i = 0; i < n; i++) {
			ArrayList<Integer> temp = new ArrayList<>(dataInt.subList(start, start + step));
			MyThread mt = new MyThread(temp, "Thread " + i);
			listThread.add(mt);
			start = start + step;
			if (i == n - 2) {
				step = end - start;
			}

		}

		for (int i = 0; i < listThread.size(); i++) {
			listThread.get(i).getThrd().start();
		}

		for (int i = 0; i < listThread.size(); i++) {
			while (listThread.get(i).getThrd().isAlive()) {
				try {
					listThread.get(i).getThrd().join();
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " interrupted");
				} catch (Exception ex) {
					System.out.println("Something wrong: " + ex.getMessage());
				}
			}
		}
	}

	public static void main(String[] args) {
		int size = 10000000;
		ArrayList<Integer> list = createRandomList(size);

		// write 10000000 random generating numbers to file Data.txt
		writeFile(list, "Data.txt");

		// read file Data.txt
		ArrayList<String> dataStr = new ArrayList<>();
		boolean check = readFile(dataStr, "Data.txt");
		if (!check) {
			System.out.println("File reading failed");
			return;
		}
		// dataInt is list input data
		ArrayList<Integer> dataInt = new ArrayList<>();
		String str[] = dataStr.get(0).split(" ");

		for (int i = 0; i < str.length; i++) {
			dataInt.add(Integer.parseInt(str[i]));
		}

		// 1000 thread for running faster
		int n = 1000;
		ArrayList<MyThread> listThread = new ArrayList<>();

		int start = 0;
		int end = size;
		listThreadExecute(listThread, dataInt, start, end, n);

		// write all prime number to file output.txt
		ArrayList<Integer> listAllPrime = new ArrayList<>();
		long sum = 0;
		for (int i = 0; i < listThread.size(); i++) {
			listAllPrime.addAll(listThread.get(i).getListPrime());
			sum += sumArray(listThread.get(i).getListPrime());
		}
		writeFile(listAllPrime, "output.txt");

		System.out.println("Sum of all prime numbers: " + sum);

	}
}
