//Bài tập 13.
//Tính T(x, n) = x^2 + x^4 + … + x^2n
//Trong đó x, n được nhập từ người dùng

package lap1_18126035;

import java.util.Scanner;

public class Exercise13 {
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
		for (int i = 2; i <= 2*n; i+=2) {
			sum += Math.pow(x, i);
			System.out.print(x + "^" + i);
			if (i < 2*n)
				System.out.print(" + ");
		}
		System.out.println("= " + sum);
	}
}
