package Week8;

class SumArray1 {
	private int sum;

	int sumArray1(int nums[]) {
		sum = 0; // reset sum

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			System.out.println("Running total for " + Thread.currentThread().getName() + " is " + sum);
			try {
				Thread.sleep(0); // allow task-switch
			} catch (InterruptedException exc) {
				System.out.println("Thread interrupted.");
			}
		}
		return sum;
	}
}

class MyThread5 implements Runnable {
	Thread thrd;
	static SumArray sa = new SumArray();
	int a[];
	int answer;

	MyThread5(String name, int nums[]) {
		thrd = new Thread(this, name);
		a = nums;
		thrd.start(); // start the thread
	}

	public void run() {
		int sum;
		System.out.println(thrd.getName() + " starting.");
// synchronize calls to sumArray()

		// gọi synchronized ở đây nè, cho phương thức nàyyy
		
		synchronized (sa) {
			answer = sa.sumArray(a);
		}
		
		System.out.println("Sum for " + thrd.getName() + " is " + answer);
		System.out.println(thrd.getName() + " terminating.");
	}
}

public class syncheroniez_Better {
	public static void main(String args[]) {
		int a[] = { 1, 2, 3, 4, 5 };
		MyThread5 mt1 = new MyThread5("Child #1", a);
		MyThread5 mt2 = new MyThread5("Child #2", a);
		try {
			mt1.thrd.join();
			mt2.thrd.join();
		} catch (InterruptedException exc) {
			System.out.println("Main thread interrupted.");
		}
	}
}
