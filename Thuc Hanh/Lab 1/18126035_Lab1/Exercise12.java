//Bai tap 12.
//Tinh T(x, n) = x + x^2 + x^3 + … + x^n
//Trong do x, n duoc nhap tu nguoi dung.
//package lap1_18126035;

import java.util.Scanner;

public class Exercise12 {
	public static void main(String[] args) {
		System.out.println("Tinh T(x, n)");

		System.out.print("Nhap x: ");
		Scanner sc1 = new Scanner(System.in);
		double x = sc1.nextDouble();

		System.out.print("Nhap n: ");
		Scanner sc2 = new Scanner(System.in);
		int n = sc2.nextInt();

		double sum = 0;
		System.out.print("T(" + x + ", " + n + ") = " + "= ");
		for (int i = 1; i <= n; i++) {
			sum += Math.pow(x, i);
			System.out.print(x + "^" + i);
			if (i < n)
				System.out.print(" + ");
		}
		System.out.println("= " + sum);
	}
}
