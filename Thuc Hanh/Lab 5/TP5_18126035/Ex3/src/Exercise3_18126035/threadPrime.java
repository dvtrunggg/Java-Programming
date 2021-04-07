package Exercise3_18126035;

import java.util.ArrayList;

public class threadPrime implements Runnable {
	private int start, end;
	private ArrayList<Integer> listPrime;
	private Thread thrd;

	// Prime p;
	public threadPrime(int start, int end, String threadName) {
		this.start = start;
		this.end = end;
		listPrime = new ArrayList<>();
		this.thrd = new Thread(this, threadName);

	}

	public threadPrime(int start, int end) {
		this.start = start;
		this.end = end;
		listPrime = new ArrayList<>();
		this.thrd = new Thread(this, "");
	}

	public threadPrime() {
		this.start = 0;
		this.end = 0;
		listPrime = new ArrayList<>();
		this.thrd = new Thread(this, "");
	}

	synchronized void findPrime() {
		try {
			listPrime = new ArrayList<>();
			if (start > end) {
				int temp = start;
				start = end;
				end = temp;
			}

			for (int i = start; i <= end; i++) {
				// Thread.sleep(500);
				Thread.sleep(0); // 0 for being faster :))
				if (isPrime(i)) {
					//System.out.println(thrd.getName() + ": [" + start + ", " + end + "] have prime numbers: \t: " + i);
					listPrime.add(i);
				}
			}
		} catch (InterruptedException ex) {
			System.out.println(Thread.currentThread().getName() + " interrupted");
		}
	}

	public void run() {
		findPrime();
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
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

	public boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
