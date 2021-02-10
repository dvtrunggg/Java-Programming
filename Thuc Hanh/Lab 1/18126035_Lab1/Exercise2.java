//Bai tap 2
//Tinh S(n) = 1^2 + 2^2 + 3^2 + … + n^2
//Trong do n duoc nhap tu nguoi dung voi 5 <= n va n <= 20

//package lap1_18126035;

import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
		// int n;
		int n = Input();
		// tinh S(n) = 1^2 + 2^2 + 3^2 + … + n^2

		int sumBinhPhuong = 0;
		for (int i = 1; i <= n; i++) {
			sumBinhPhuong += i * i;
			System.out.print(i + "^2");
			if (i < n)
				System.out.print(" + ");
		}
		System.out.println(" = " + sumBinhPhuong);
	}

	public static int Input() {
		int n;
		do {
			System.out.print("Nhap n (5 <= n <= 20): ");
			Scanner sc = new Scanner(System.in);
			n = Integer.parseInt(sc.nextLine());
			if (n < 5 || n > 20) {
				System.out.println("Khong hop le, moi nhap lai! (5 <= n <= 20)");
			}

		} while (n < 5 || n > 20);
		return n;

	}
}
