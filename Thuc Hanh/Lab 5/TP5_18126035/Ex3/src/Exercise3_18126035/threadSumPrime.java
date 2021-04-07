package Exercise3_18126035;

import java.util.ArrayList;

public class threadSumPrime implements Runnable {
	private Thread thrd;
	private threadPrime thrdPrime;
	private int sum ;


	public Thread getThrd() {
		return thrd;
	}

	public void setThrd(Thread thrd) {
		this.thrd = thrd;
	}

	public threadPrime getThrdPrime() {
		return thrdPrime;
	}

	public void setThrdPrime(threadPrime thrdPrime) {
		this.thrdPrime = thrdPrime;
	}

	public threadSumPrime(threadPrime tp, String name) {
		this.thrdPrime = tp;
		this.thrd = new Thread(this, name);
	}


	public void run() {
		try {
			sum = 0;
			Thread.sleep(200);
			for (int i = 0; i < thrdPrime.getListPrime().size(); i++) {

				sum += thrdPrime.getListPrime().get(i);
			}

		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrupted");
		}
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}
