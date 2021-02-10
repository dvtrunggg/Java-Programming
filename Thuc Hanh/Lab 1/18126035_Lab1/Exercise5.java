//Bai tap 5.
//Tinh S(n) = 1 + 1/3 + 1/5 +... + 1/2n+1
//Trong do n duoc nhap tu nguoi dung voi n >= 2.

//package lap1_18126035;

import java.util.Scanner;

public class Exercise5 {
	public static int Input() {
		int n;
		do {
			System.out.print("Nhap n (n >= 2): ");
			Scanner sc = new Scanner(System.in);
			n = Integer.parseInt(sc.nextLine());
			if (n < 2) {
				System.out.println("Khong hop le, moi nhap lai! (n >= 2)");
			}
		} while (n < 2);
		return n;

	}

	public static void main(String[] args) {
		int n = Input();
		double sum = 0;
		for (int i = 1; i <= 2 * n + 1; i += 2) {
			sum += (double) 1 / i;

			System.out.print("1/" + i + " ");
			if (i < 2 * n + 1)
				System.out.print(" + ");
		}
		System.out.println(" = " + sum);
	}
}
