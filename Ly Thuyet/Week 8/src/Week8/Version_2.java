package Week8;

class MyThread12 implements Runnable {
	Thread thrd;

	MyThread12(String name) {
		thrd = new Thread(this, name);
	}

	public static MyThread12 createAndStart(String name) {
		MyThread12 myThrd = new MyThread12(name);
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

public class Version_2 {
	public static void main(String[] args) {
		System.out.println("Main thread starting.");
		
		// Create and start a thread.
		//MyThread12 mt = MyThread12.createAndStart("Child #1");
		MyThread12 mt = new MyThread12("Child #1");
		//mt.thrd.start();
		
mt.thrd.start();		
		for (int i = 0; i < 50; i++) {
			System.out.print(".");
			try {
				Thread.sleep(100);
			} catch (InterruptedException exc) {
				System.out.println("Main thread interruped.");
			}
		}
		
		System.out.println("Main thread ending.");
	}
}
