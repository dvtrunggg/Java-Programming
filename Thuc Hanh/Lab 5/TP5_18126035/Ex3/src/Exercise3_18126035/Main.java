package Exercise3_18126035;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		int start = 1;
		int end = 100000;
		threadPrime Thread1 = new threadPrime(start, end, "Thread 1");
		threadSumPrime Thread2 = new threadSumPrime(Thread1, "Thread 2");

		Thread1.getThrd().start();
		Thread2.getThrd().start();
		Thread1.getThrd().join();
		Thread2.getThrd().join();

		System.out.println(Thread1.getListPrime());
		System.out.println("Total of all prime number: " + Thread2.getSum());

		threadSumDigits Thread3 = new threadSumDigits(Thread1, "Thread 3");
		Thread3.getThrd().start();
		Thread3.getThrd().join();

	}
}
