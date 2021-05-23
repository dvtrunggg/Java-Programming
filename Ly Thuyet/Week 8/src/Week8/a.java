package Week8;

import java.util.ArrayList;

class ds implements Runnable {
	ArrayList<Integer> list = new ArrayList<>();
	Thread thrd;

	public ds(String name) {
		thrd = new Thread(this, name);
	}

	public ds() {
		thrd = new Thread();
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(0);
				System.out.print(i + "\t");
				list.add(i);
			} catch (InterruptedException e) {
				System.out.println("abc");

			}
		}
		System.out.println();

	}
}

class somme implements Runnable {
	static ds ls;
	Thread th2;
	int sum = 0;

	public somme(ds list, String name) {
		th2 = new Thread(this, name);
		list = new ds();
	}

	public void run() {
		synchronized (ls) {
			for (int i = 0; i < ls.list.size(); i++) {
				sum += ls.list.get(i);
			}

			System.out.println(sum);
		}

	}

}

public class a {
	public static void main(String[] args) throws InterruptedException {
		ds a = new ds("T1");

		a.thrd.start();

		a.thrd.join();
		System.out.println(a.list);
		
		
		somme b = new somme(a, "T2");
		b.th2.start();
		b.th2.join();

		

		System.out.println(b.sum);
	}
}