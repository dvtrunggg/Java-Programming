package Exercise2_18126035;

import java.util.*;

public class Mythread implements Runnable {
	private Thread thrd;
	private ArrayList<Integer> list;

	public Mythread(String name) {
		this.thrd = new Thread(this, name);
		this.list = new ArrayList<>();
	}

	public Mythread(ArrayList<Integer> list, String name) {

		this.thrd = new Thread(this, name);
		this.list = list;
	}

	public Thread getThrd() {
		return thrd;
	}

	public void setThrd(Thread thrd) {
		this.thrd = thrd;
	}

	public ArrayList<Integer> getList() {
		return list;
	}

	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}

	public void run() {
		try {

			Thread.sleep(0);
			Collections.sort(this.list);

		} catch (InterruptedException e) {
			System.out.println(thrd.getName() + " interrupted!");
		}
	}

}
