//Bài tập 15.
//Tính S(n) = 1 + 1/(1+2) + 1/(1+2+3) + ... + 1/(1+2+3+...+n)
//Trong đó n được nhập từ người dùng

package lap1_18126035;

import java.util.Scanner;

public class Exercise15 {
	// dùng recusive
	public static double tongS(int n) {
		if (n == 1)
			return 1;
		double sum = 1;
		for (int i = 2; i <= n; i++) {
			sum += i;
		}
		return tongS(n - 1) + 1 / sum;
	}



	public static void main(String[] args) {
		System.out.print("Nhap n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print("S(" + n + ") = ");

		for (int i = 1; i <= n; i++) {
			System.out.print("1/(");
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
				if (j < i)
					System.out.print("+");

			}
			System.out.print(")");
			if (i < n)
				System.out.print(" + ");
		}
		double temp;
		System.out.println(" = " + tongS(n));
	}
}
