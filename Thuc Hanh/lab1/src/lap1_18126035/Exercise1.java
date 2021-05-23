//Bài tập 1.
//Tính S(n) = 1 + 2 + 3 + 4 + … + n
//Trong đó n được nhập từ người dùng với 3 < n và n < 50.

package lap1_18126035;

import java.util.Iterator;
import java.util.Scanner;

public class Exercise1 {
	public static void main(String[] args) {
		int n = Input();
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
			System.out.print(i);
			if (i < n)
				System.out.print(" + ");
		}
		System.out.print(" = " + sum);

	}

	public static int Input() {
		int n;
		do {
			System.out.print("Nhap n (3<n<50): ");
			Scanner sc = new Scanner(System.in);
			n = Integer.parseInt(sc.nextLine());
			if (n < 3 || n > 50) {
				System.out.println("Khong hop le, moi nhap lai! (3<n<50)");
			}
		} while (n < 3 || n > 50);
		return n;

	}
}
