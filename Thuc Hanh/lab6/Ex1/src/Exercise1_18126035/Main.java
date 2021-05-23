package Exercise1_18126035;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
	public static void writeFile(ArrayList<String> data, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);

			for (String dt : data) {
				bw.write(dt);
				bw.newLine();
			}

			bw.newLine();
			bw.close();
			osw.close();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// n is the number of threads
	public static void listThreadExecute(ArrayList<MyThread_Prime> listThread, int start, int end, int n) {
		int step = (end - start) / n;
		for (int i = 1; i <= n; i++) {
			MyThread_Prime mt = new MyThread_Prime(start, start + step, "Thread " + i);

			// update start
			start = start + step + 1;

			// neu là vòng lặp cuối cùng thì cho step = tất cả các số còn lại
			// if its in last loop => step = all remaining number
			if (i == n - 1) {
				step = end - start;
			}
			listThread.add(mt);
		}

//		for (int i = 0; i < list.size(); i++) {
//			list.get(i).getThrd().start();
//		}

		for (int i = 0; i < listThread.size(); i++) {
			listThread.get(i).getThrd().start();
			while (listThread.get(i).getThrd().isAlive()) {
				try {
					listThread.get(0).getThrd().join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		//readfile
		ArrayList<String> data = readFile("data.txt");
		int start = Integer.parseInt(data.get(0));
		int end = Integer.parseInt(data.get(1));

		// tạo ra 6 thread
		int n = 6;
		System.out.print("Enter the number of threads: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		ArrayList<MyThread_Prime> listThreads = new ArrayList<>();
		listThreadExecute(listThreads, start, end, n);

		// convert array to array string for writing file
		ArrayList<String> listString = new ArrayList<>();
		for (int i = 0; i < listThreads.size(); i++) {
			listString.add(listThreads.get(i).getListPrime().toString());
		}

		//write file
		writeFile(listString, "output.txt");

		System.out.println("ok");
	}
}
