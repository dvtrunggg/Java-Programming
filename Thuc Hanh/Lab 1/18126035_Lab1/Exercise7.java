//Bai tap 7.
//Tinh S(n) = 1/2 + 2/3 + 3/4 +... + n/(n+1)
//Trong do n duoc nhap tu nguoi dung voi n >= 1. 

//package lap1_18126035;

import java.util.Scanner;

public class Exercise7 {
	public static int Input() {
		int n;
		do {
			System.out.print("Nhap n (n >= 1): ");
			Scanner sc = new Scanner(System.in);
			n = Integer.parseInt(sc.nextLine());
			if (n < 1) {
				System.out.println("Khong hop le, moi nhap lai! (n >= 1)");
			}
		} while (n < 1);
		return n;

	}

	public static void main(String[] args) {
		int n = Input();
		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += (double) i / (i+1);

			System.out.print( i + "/" + (i + 1));
			if (i < n)
				System.out.print(" + ");
		}
		System.out.println(" = " + sum);
	}
}
