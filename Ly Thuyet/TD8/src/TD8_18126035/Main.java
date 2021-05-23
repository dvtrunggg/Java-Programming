package TD8_18126035;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

public class Main {
	public static void main(String[] args) {

		//temp d'execution du programme
		long beginTime = Calendar.getInstance().getTimeInMillis();

		int n = 10;
		 Scanner sc = new Scanner(System.in);
		
		 System.out.print("Entrez nombre des threads: ");
		 n = sc.nextInt();

		int start = 1;
		int end = 100000;
		int step = (end - start) / n;

		
		//diviser le tableau par threads
		ArrayList<MyThreads> listThreads = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			MyThreads mt = new MyThreads("Thread " + i, start, start + step);

			start = start + step;

			if (i == n - 1) {
				step = end - start;
			}

			listThreads.add(mt);

		}

		//start threads dans listThreads
		for (int i = 0; i < listThreads.size(); i++) {
			listThreads.get(i).thrd.start();
		}

		//utiliser join 
		try {
			for (int i = 0; i < listThreads.size(); i++) {
				listThreads.get(i).thrd.join();
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}

		//// trouver le plus grand nombre de diviseurs dans threads
		int largest = listThreads.get(0).getNomPlus();
		for (int i = 0; i < listThreads.size(); i++) {
			if (listThreads.get(i).getNomPlus() > largest)
				largest = listThreads.get(i).getNomPlus();
		}

		//print nombres ont le plus grand nombre de diviseurs
		System.out.print("Dans [1, 100000]: Nombres avec le plus diviseurs (" + largest + " diviseurs) est: ");
		for (int i = 0; i < listThreads.size(); i++) {
			if (listThreads.get(i).getNomPlus() == largest) {
				largest = listThreads.get(i).getNomPlus();
				System.out.print(listThreads.get(i).getList());
			}
		}
		
		
		//endTime pour trouver temp d'execution du programme
		long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("\nExecuted Time: " + (endTime - beginTime) + " millis");
	}

}
