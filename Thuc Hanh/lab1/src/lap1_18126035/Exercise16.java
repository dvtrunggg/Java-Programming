//Bài tập 16.
//Tính S(x, n) = x + (x*2)/(1+2) + (x*3)/(1+2+3) + ... + (x*n)/(1+2+3+...+n)
//Trong đó x, n được nhập từ người dùng

package lap1_18126035;

import java.util.Scanner;

public class Exercise16 {
	public static void main(String[] args) {
		System.out.println("Tinh S(x, n)");

		System.out.print("Nhap x: ");
		Scanner sc1 = new Scanner(System.in);
		double x = sc1.nextDouble();

		System.out.print("Nhap n: ");
		Scanner sc2 = new Scanner(System.in);
		int n = sc2.nextInt();

		double sum = x;
		System.out.print("S(" + x + ", " + n + ") = " + "= ");
		System.out.print(x + " + ");

		for (int i = 2; i <= n; i++) {
			System.out.print("(" + x + "*" + i + ")/(");

			int denominator = 0; // mẫu số của từng phân số
			for (int j = 1; j <= i; j++) {
				denominator += j;
				System.out.print(j);
				if (j < i)
					System.out.print(" + ");
			}

			sum += (x * i) / denominator;   //tổng của các phân số
			
			System.out.print(") ");
			if (i < 2 * n)
				System.out.print(" + ");
		}
		System.out.println("= " + sum);
	}
}
