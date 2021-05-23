package TD8_18126035;

import java.util.LinkedList;

public class MyThreads implements Runnable {
	Thread thrd;
	// private String threadName;
	int start; // nombre start
	int end; // nombre end
	int nomPlus; // le plus grand nombre de diviseurs
	LinkedList<Integer> list; // list contient element avec le plus grand nombre de diviseurs

	public MyThreads(String name, int start, int end) {
		this.thrd = new Thread(this, name);
		this.start = start;
		this.end = end;
		this.nomPlus = 1;
		list = new LinkedList<>();

	}

	public void setList(LinkedList<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		System.out.println(thrd.getName() + " Starting. ");

		try {
			int largest = 1;
			System.out.println();
			for (int i = start; i <= end; i++) {
				// Thread.sleep(200);
				Thread.sleep(0);  //0 pour programme est vite, je ne veux pas attendre longtemps:))

				if (NomDeviseurs.nomDiv(i) > largest)
					largest = NomDeviseurs.nomDiv(i);
			}

			this.nomPlus = largest;
			for (int i = start; i <= end; i++) {
				// Thread.sleep(200);
				Thread.sleep(0);  //0 pour programme est vite, je ne veux pas attendre longtemps:))

				if (NomDeviseurs.nomDiv(i) == largest) {
					list.add(i);
					System.out.print(thrd.getName() + ": [" + start + ", " + end + "]: \t");
					System.out
							.println("\tNombre a le plus de diviseurs est " + i + " avec " + largest + " diviseurs. ");
				}
			}
		} catch (InterruptedException exc) {
			System.out.println(thrd.getName() + " interrupted!");

		}
		System.out.println();
		System.out.println(thrd.getName() + " terminating!");
	}

	public static MyThreads createAndStart(String name, int start, int end) {
		MyThreads myThrd = new MyThreads(name, start, end);
		myThrd.thrd.start();
		return myThrd;
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

	public LinkedList<Integer> getList() {
		return list;
	}

	public int getNomPlus() {
		return nomPlus;
	}

	public void setNomPlus(int nomPlus) {
		this.nomPlus = nomPlus;
	}

}
