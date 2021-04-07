package Exercise5_18126035;

import java.util.Scanner;

public class Main {
	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	public static void main(String[] args) {
		System.out.print("Nhap vao quang duong: ");
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int temp = getRandomNumber(1, s);
		// int temp=-1;
		System.out.println(temp);
		myThread boss = new myThread(s, temp);

		// boss.setCoor_boss(temp);
		Thread t1 = new Thread(boss);
		t1.setName("BOSS");
		t1.start();
		// System.out.println(t1.getPriority());
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myThread mt2 = new myThread(s, temp);
		Thread t2 = new Thread(mt2);
		t2.setName("Blue car");
		t2.start();

		myThread mt3 = new myThread(s, temp);
		Thread t3 = new Thread(mt3);
		t3.setName("Red car");
		t3.start();
	}
}
