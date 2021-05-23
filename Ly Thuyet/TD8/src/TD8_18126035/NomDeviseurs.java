package TD8_18126035;

import java.util.ArrayList;
import java.util.LinkedList;


public class NomDeviseurs {

	// trouver le nombre de divisieurs de n
	public static int nomDiv(int n) {
		int count = 0;
	    for (int i = 1; i <= Math.sqrt(n); i++) {
	        if (n % i == 0) {
	            // Si les diviseurs sont egaux,
	            // ne comptez qu'un
	            if (n / i == i)
	                count++;
	 
	            else // Sinon, comptez les deux
	                count = count + 2;
	        }
	    }
	    return count;
	}

	// Ex: avec [1,20] => list = [6, 12, 18, 20] c.a.d 6 est le plus grand nombre de diviseurs
	// 12, 18, 20 est nombres avec diviseurs = 6
	public static LinkedList<Integer> List(int start, int end) {
		int largest = 1;
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = start; i <= end; i++) {
			if (NomDeviseurs.nomDiv(i) > largest) {
				largest = nomDiv(i);
			}
		}

		list.add(largest);
		for (int i = start; i <= end; i++) {
			if (nomDiv(i) == largest) {
				list.add(i);
			}
		}

		// format de list: [largest, num1, num2,...].
		return list;
	}


}
