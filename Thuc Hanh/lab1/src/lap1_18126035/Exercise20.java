//Bài tập 20.
//Tính S(x, n) = 1 + x + (x*3)/3! + (x*5)/5! + ... + (x*2n+1)/(2n+1)!
//Trong đó x, n được nhập từ người dùng

package lap1_18126035;

import java.util.Scanner;

public class Exercise20 {

	// tính giai thừa = recusive
	public static int giaiThua_Recusive(int n) {
		if (n == 1 || n == 0)
			return 1;
		return giaiThua_Recusive(n - 1) * n;
	}

	// tính giai thừa = vòng lặp (khử đệ quy)
	public static int giaiThua_Loop(int n) {
		int factorial = 1;
		for (int i = 2; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static void main(String[] args) {
		System.out.println("Tinh S(x, n)");

		System.out.print("Nhap x: ");
		Scanner sc1 = new Scanner(System.in);
		double x = sc1.nextDouble();

		System.out.print("Nhap n: ");
		Scanner sc2 = new Scanner(System.in);
		int n = sc2.nextInt();

		System.out.print("S(" + x + ", " + n + ") = ");
		System.out.print("1 + " + x + " + ");
		double sum = 1 + x;
		
		//bắt đầu từ 3 vì đã gán sum = 1+x
		for (int i = 3; i <= ((2 * n) + 1); i += 2) {
			//// tính giai thừa = dùng recusive
			// sum += (double) (x * i) / giaiThua_Recusive(i);

			//// tính giai thừa = dùng loop
			sum += (double) ((x * i) / giaiThua_Loop(i));

			System.out.print("(" + x + "*" + i + ")/" + i + "!");
			if (i < (2 * n + 1))
				System.out.print(" + ");
		}
		System.out.println(" = " + sum);

	}
}
