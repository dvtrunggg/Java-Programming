package Exercise2_18126035;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

	// create random a array
	public static ArrayList<Integer> createRandomList(int n) {

		ArrayList<Integer> list = new ArrayList<>();
		Random rand = new Random();

		int max = 1000000;
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

	public static void main(String[] args) throws InterruptedException {
		//generate a random element array
		ArrayList<Integer> list = createRandomList(2500000);
		
		//heap array
		ArrayList<Integer> subList1 = new ArrayList<>(list.subList(0, 999999));
		ArrayList<Integer> subList2 = new ArrayList<>(list.subList(1000000, 1499999));
		ArrayList<Integer> subList3 = new ArrayList<>(list.subList(1500000, 2500000));



		Mythread mt1 = new Mythread(subList1, "Thread 1");
		Mythread mt2 = new Mythread(subList2, "Thread 2");
		Mythread mt3 = new Mythread(subList3, "Thread 3");
		
		mt1.getThrd().start();
		mt2.getThrd().start();
		mt3.getThrd().start();	
		
		mt1.getThrd().join();
		mt2.getThrd().join();
		mt3.getThrd().join();
		
		ArrayList<Integer> sumList = new ArrayList<>();
		sumList.addAll(subList1);
		sumList.addAll(subList2);
		sumList.addAll(subList3);
		
		writeFile(sumList, "output.txt");

	}
}
