//Bài tập 4.
//Tính S(n) = 1/2 + 1/4 + 1/6 +... + 1/2n
//Trong đó n được nhập từ người dùng với n > 9.

package lap1_18126035;

import java.util.Scanner;

public class Exercise4 {
	public static int Input() {
		int n;
		do {
			System.out.print("Nhap n (n > 9): ");
			Scanner sc = new Scanner(System.in);
			n = Integer.parseInt(sc.nextLine());
			if (n <= 9) {
				System.out.println("Khong hop le, moi nhap lai! (n > 9)");
			}
		} while (n <= 9);
		return n;

	}

	public static void main(String[] args) {
		int n = Input();
		double sum = 0;
		for (int i = 2; i <= 2*n; i+=2) {
			sum += (double) 1 / i;

			System.out.print("1/" + i + " ");
			if (i < 2*n)
				System.out.print(" + ");
		}
		System.out.println(" = " + sum);
	}
}
