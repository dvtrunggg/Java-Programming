//Bai tap 1.
//Tinh S(n) = 1 + 2 + 3 + 4 + … + n
//Trong do n duoc nhap tu nguoi dung voi 3 < n va n < 50.

//package lap1_18126035;

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
