package Week2;

public class Logical0pTable_18126035 {
	public static void main(String[] args) {

		
		int[] a = {1,1,0,0};
		int[] b = {1,0,1,0};

		
		System.out.println("P\t Q\t AND\t OR\t XOR\t NOT\t");
		for (int i = 0; i < 4; i++) {
			System.out.println(a[i] + "\t " + b[i] + "\t " + (a[i] & b[i]) + "\t " + (a[i] | b[i]) + "\t " + (a[i] ^ b[i])
					+ "\t " + (1 - a[i]));
		}

		
		boolean[] p = { true, true, false, false };
		boolean[] q = { true, false, true, false };
		System.out.println("\nP\t Q\t AND\t OR\t XOR\t NOT\t");
		for (int i = 0; i < 4; i++) {
			System.out.println(p[i] + "\t" + q[i] + "\t" + (p[i] & q[i]) + "\t" + (p[i] | q[i]) + "\t" + (p[i] ^ q[i])
					+ "\t" + (!p[i]));

		}
	
		
	}

}
