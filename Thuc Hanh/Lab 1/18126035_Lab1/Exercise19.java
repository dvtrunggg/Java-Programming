//Bai tap 19.
//Tinh S(x, n) = 1 + (x*2)/2! + (x*4)/4! + ... + (x*2n)/(2n)!
//Trong do x, n duoc nhap tu nguoi dung.

//package lap1_18126035;

import java.util.Scanner;

public class Exercise19 {
	// tinh giai thua = recusive
	public static int giaiThua_Recusive(int n) {
		if (n == 1 || n == 0)
			return 1;
		return giaiThua_Recusive(n - 1) * n;
	}

	// tinh giai thua = vong lap (khu de quy)
	public static int giaiThua_Loop(int n) {
		int factorial = 1;
		for (int i = 2; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static void main(String[] args) {
		System.out.println("Tinh S(x, n)");

		System.out.print("Nhap x: ");
		Scanner sc1 = new Scanner(System.in);
		double x = sc1.nextDouble();

		System.out.print("Nhap n: ");
		Scanner sc2 = new Scanner(System.in);
		int n = sc2.nextInt();

		System.out.print("S(" + x + ", " + n + ") = ");
		System.out.print("1 + ");
		double sum = 1;
		for (int i = 2; i <= 2 * n; i += 2) {
			//// tinh giai thua = dung recusive
			// sum += (double) (x * i) / giaiThua_Recusive(i);

			//// tinh giai thua = dung loop
			sum += (double) ((x * i) / giaiThua_Loop(i));

			System.out.print("(" + x + "*" + i + ")/" + i + "!");
			if (i < 2 * n)
				System.out.print(" + ");
		}
		System.out.println(" = " + sum);

	}

}
