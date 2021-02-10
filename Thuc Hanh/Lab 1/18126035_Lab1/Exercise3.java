//Bai tap 3.
//Tinh S(n) = 1 + 1/2 + 1/3 + ... + 1/n
//Trong do n duoc nhap tu nguoi dung voi n >= 7. 

//package lap1_18126035;

import java.util.Scanner;

public class Exercise3 {
	public static int Input() {
		int n;
		do {
			System.out.print("Nhap n (n >= 7): ");
			Scanner sc = new Scanner(System.in);
			n = Integer.parseInt(sc.nextLine());
			if (n < 7) {
				System.out.println("Khong hop le, moi nhap lai! (n >= 7)");
			}
		} while (n < 7);
		return n;

	}

	public static void main(String[] args) {
		int n = Input();
		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += (double)1 / i;
			
			System.out.print("1/" + i + " ");
			if (i < n)
				System.out.print(" + ");
		}
		System.out.println(" = " + sum);
	}
}
