package Exercise3_18126035;

import java.util.ArrayList;

public class threadSumDigits implements Runnable {
	private Thread thrd;
	private threadPrime thPrime;

	private ArrayList<Integer> listSumDigits;

	public threadSumDigits(threadPrime thPrime, String name) {

		this.thrd = new Thread(this, name);
		this.thPrime = thPrime;
	}

	public Thread getThrd() {
		return thrd;
	}

	public void setThrd(Thread thrd) {
		this.thrd = thrd;
	}

	public threadPrime getThPrime() {
		return thPrime;
	}

	public void setThPrime(threadPrime thPrime) {
		this.thPrime = thPrime;
	}

	public static int sumDigits(int n) {
		int sum = 0;
		while (n != 0) {
			sum = sum + n % 10;
			n = n / 10;
		}
		return sum;
	}

	public void countDigits() {
		try {
			listSumDigits = new ArrayList<>();
			Thread.sleep(0);
			for (int i = 0; i < this.thPrime.getListPrime().size(); i++) {
				System.out.println(thPrime.getListPrime().get(i) + " has total of digits = " + sumDigits(thPrime.getListPrime().get(i)));
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrupted");
		}
	}

	public void run() {
		countDigits();
	}

	public ArrayList<Integer> getListSumDigits() {
		return listSumDigits;
	}

	public void setListSumDigits(ArrayList<Integer> listSumDigits) {
		this.listSumDigits = listSumDigits;
	}
	
	

}
