//Bài tập 8.
//Tính S(n) = 1/2 + 3/4 + 5/6 +... + (2n+1)/(2n+2)
//Trong đó n được nhập từ người dùng với n > 5. 

package lap1_18126035;

import java.util.Scanner;

public class Exercise8 {
	public static int Input() {
		int n;
		do {
			System.out.print("Nhap n (n > 5): ");
			Scanner sc = new Scanner(System.in);
			n = Integer.parseInt(sc.nextLine());
			if (n <= 5) {
				System.out.println("Khong hop le, moi nhap lai! (n > 5)");
			}
		} while (n <= 5);
		return n;

	}

	public static void main(String[] args) {
		int n = Input();
		double sum = 0;
		for (int i = 1; i <= (2 * n + 3); i += 2) {
			sum += (double) i / (i + 1); // 1 số lẻ / 1 số chẵn

			System.out.print(i + "/" + (i + 1));
			if (i < 2 * n + 3)
				System.out.print(" + ");
		}
		System.out.println(" = " + sum);
	}
}
