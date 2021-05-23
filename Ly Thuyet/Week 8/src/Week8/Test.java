package Week8;

class MonThread implements Runnable {
	Thread thrd;

	MonThread(String name) {
		thrd = new Thread(this, name);
	}

	public static MonThread createAndStart(String name) {
		MonThread myThrd = new MonThread(name);
		myThrd.thrd.start();
		return myThrd;
	}

	@Override
	public void run() {
		System.out.println(thrd.getName() + " starting.");
		try {
			for (int count = 0; count < 10; count++) {
				Thread.sleep(400);
				System.out.println("In " + thrd.getName() + ", count is " + count);
			}
		} catch (InterruptedException exc) {
			System.out.println(thrd.getName() + " interrupted.");
		}
		System.out.println(thrd.getName() + " terminating.");
	}
}

public class Test {
	public static void main(String[] args) {
		System.out.println("Main thread starting.");

		// Create and start a thread.
//		MonThread mt1 = MonThread.createAndStart("Child #1");
//
//		MonThread mt2 = MonThread.createAndStart("Child #2");
//
//		MonThread mt3 = MonThread.createAndStart("Child #3");

//		do {
//			System.out.print(".");
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException exc) {
//				System.out.println("Main thread interruped.");
//			}
//		} while (mt1.thrd.isAlive() || mt2.thrd.isAlive() || mt3.thrd.isAlive());

//		try {
//			mt1.thrd.join();
//			System.out.println("Child #1 joined.");
//
//			mt2.thrd.join();
//			System.out.println("Child #2 joined.");
//
//			mt3.thrd.join();
//			System.out.println("Child #3 joined.");
//
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//			System.out.println("Main thread interruped.");
//		}

		MonThread mt1 = MonThread.createAndStart("High Priority");

		MonThread mt2 = MonThread.createAndStart("Low Priority");

		MonThread mt3 = MonThread.createAndStart("Normal Priority #1");
		MonThread mt4 = MonThread.createAndStart("Normal Priority #2");
		MonThread mt5 = MonThread.createAndStart("Normal Priority #3");

		mt1.thrd.setPriority(Thread.NORM_PRIORITY + 2);
		mt2.thrd.setPriority(Thread.NORM_PRIORITY - 2);

		mt1.thrd.start();
		mt2.thrd.start();
		mt3.thrd.start();
		mt4.thrd.start();
		mt5.thrd.start();
		
		
		try {
			mt1.thrd.join();

			mt2.thrd.join();

			mt3.thrd.join();
			mt4.thrd.join();

			mt5.thrd.join();

		} catch (InterruptedException e) {
			System.out.println("Main thread interruped.");
		}
		
		
		
		System.out.println("Main thread ending.");

	}
}
