//Bai tap 14.
//Tinh S(n) = x + x^3 + … + x^2n+1
//Trong do x, n duoc nhap tu nguoi dung. 

//package lap1_18126035;

import java.util.Scanner;

public class Exercise14 {
	public static void main(String[] args) {
		System.out.println("Tinh S(x, n)");

		System.out.print("Nhap x: ");
		Scanner sc1 = new Scanner(System.in);
		double x = sc1.nextDouble();

		System.out.print("Nhap n: ");
		Scanner sc2 = new Scanner(System.in);
		int n = sc2.nextInt();

		double sum = 0;
		System.out.print("S("+n+") (voi x = "+x+") = ");
		for (int i = 1; i <= 2 * n +1; i += 2) {
			sum += Math.pow(x, i);
			System.out.print(x + "^" + i);
			if (i < 2 * n +1)
				System.out.print(" + ");
		}
		System.out.println("= " + sum);
	}
}
