//Bai tap 9.
//Tinh S(n) = 1 * 2 * 3 * … * n
//Trong do n duoc nhap tu nguoi dung voi n > 6. 

//package lap1_18126035;

import java.util.Scanner;

public class Exercise9 {
	public static int Input() {
		int n;
		do {
			System.out.print("Nhap n (n > 6): ");
			Scanner sc = new Scanner(System.in);
			n = Integer.parseInt(sc.nextLine());
			if (n <= 6) {
				System.out.println("Khong hop le, moi nhap lai! (n > 6)");
			}
		} while (n <= 6);
		return n;

	}

	public static void main(String[] args) {
		int n = Input();
		int sum = 1;
		for (int i = 1; i <= n; i++) {
			sum *= i;

			System.out.print(i);
			if (i < n)
				System.out.print(" * ");
		}
		System.out.println(" = " + sum);
	}
}
