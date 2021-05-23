package Exercise1_18126035;

/**
 * 
 * @author trung
 * Using multithread for program runs faster
 *
 */

import java.util.*;

public class MyThread implements Runnable {
	private ArrayList<Integer> listData;
	private ArrayList<Integer> listPrime;
	private Thread thrd;

	// Prime p;
	public MyThread(ArrayList<Integer> listNumber, String threadName) {
		this.listData = listNumber;
		this.listPrime = new ArrayList<>();
		this.thrd = new Thread(this, threadName);

	}

//	public MyThread(String name) {
//		this.thrd = new Thread(this, name);
//		this.listPrime = new ArrayList<>();
//	}

	public void findPrime() {
		try {

			for (int i = 0; i < listData.size(); i++) {
				// Thread.sleep(500);
				Thread.sleep(0); // 0 for being faster :))
				if (isPrime(listData.get(i))) {

					listPrime.add(listData.get(i));
				}
			}
		} catch (InterruptedException ex) {
			System.out.println(Thread.currentThread().getName() + " interrupted");
		} catch (Exception ex) {
			System.out.println("Something wrong: " + ex.getMessage());
		}
	}

	public void run() {
		findPrime();
	}

//	public boolean isPrime(int n) {
//		if (n <= 1)
//			return false;
//		for (int i = 2; i <= n / 2; i++) {
//			if (n % i == 0)
//				return false;
//		}
//		return true;
//	}

	//Improved prime number finding algorithm
	public boolean isPrime(int n) {
		// Corner cases
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		// This is checked so that we can skip
		// middle five numbers in below loop
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

	public ArrayList<Integer> getListData() {
		return listData;
	}

	public void setListData(ArrayList<Integer> listData) {
		this.listData = listData;
	}

	public ArrayList<Integer> getListPrime() {
		return listPrime;
	}

	public void setListPrime(ArrayList<Integer> listPrime) {
		this.listPrime = listPrime;
	}

	public Thread getThrd() {
		return thrd;
	}

	public void setThrd(Thread thrd) {
		this.thrd = thrd;
	}

}
