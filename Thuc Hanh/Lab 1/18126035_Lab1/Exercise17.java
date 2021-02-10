//Bai tap 17.
//Tinh S(n) = n!
//Trong do n duoc nhap tu nguoi dung.

//package lap1_18126035;

import java.util.Scanner;

public class Exercise17 {
	public static int giaiThua(int n) {
		if (n == 1 || n == 0)
			return 1;
		return giaiThua(n - 1) * n;
	}

	public static void main(String[] args) {
		System.out.print("Tinh S(n) = n! \nNhap n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		////dung recusive
		//System.out.println("S(" + n + ") = " + n + "! = " + giaiThua(n));
		
		////dung vong lap
		int factorial = 1;
		for(int i = 2; i<=n;i++)
		{
			factorial *= i;
		}
		System.out.println("S(" + n + ") = " + n + "! = " + factorial);
		
	}
}
