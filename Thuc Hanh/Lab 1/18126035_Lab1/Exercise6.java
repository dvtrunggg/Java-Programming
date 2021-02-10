//Bai tap 6.
//Tinh S(n) = 1/1*2 + 1/2*3 + 1/3*4 +... + 1/n*(n+1)
//Trong do n duoc nhap tu nguoi dung voi n > 6. 

//package lap1_18126035;

import java.util.Scanner;

public class Exercise6 {
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
		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += (double) 1 / (i * (i + 1));

			System.out.print("1/" + i + "*" + (i + 1) + " ");
			if (i < n)
				System.out.print(" + ");
		}
		System.out.println(" = " + sum);
	}

}
