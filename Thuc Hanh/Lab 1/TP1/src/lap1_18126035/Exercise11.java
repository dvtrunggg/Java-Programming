//Bài tập 11.
//Tính S(n) = 1 + 1*2 + 1*2*3 + … + 1*2*3…*n
//Trong đó n được nhập từ người dùng. 

package lap1_18126035;

import java.util.Scanner;

public class Exercise11 {
	public static int giaiThua(int n) {
		if (n == 1 || n == 0)
			return 1;
		return giaiThua(n - 1) * n;
	}

	public static int tongDayGiaiThua(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += giaiThua(i);
		}
		return sum;

	}

	public static void main(String[] args) {
		System.out.print("Nhap n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
				if (j < i)
					System.out.print("*");
			}
			if (i < n)
				System.out.print(" + ");
		}
		System.out.print("= " + tongDayGiaiThua(n));
	}
}
