package lap2_18126035;

import java.util.Scanner;

public class Exercise3 {
	public static void main(String[] args) {

		int b[][] = new int[3][];
		b[0] = new int[4];
		b[1] = new int[5];
		b[2] = new int[6];

		b[0][0] = 3;
		b[0][1] = 5;
		b[0][2] = 2;
		b[0][3] = 12;
		b[1][1] = 15;
		b[1][2] = -2;
		b[1][0] = 6;
		b[1][3] = 5;
		b[1][4] = 12;
		b[2][0] = 5;
		b[2][1] = -10;
		b[2][2] = -9;
		b[2][3] = -10;
		b[2][4] = 0;
		b[2][5] = 2;

		MangRangCua a = new MangRangCua(3);
		a.setA(b);

		// a.Input();
		a.Output();

		System.out.println("Sap xep cac dong: ");
		a.selectionSort();
		a.Output();

		System.out.println("Tong cac phan tu: " + a.Sum());
		System.out.println("Tich cac phan tu: " + a.Multiplication());

		System.out.println("The largest element in array: " + a.Max());

		if (a.maxNegative() > 0)
			System.out.println("Array has no negative element!");
		else
			System.out.println("The largest negative element in array: " + a.maxNegative());

		if (a.minPosstive() < 0)
			System.out.println("Array has no positive element!");
		else
			System.out.println("The smallest positive element in array: " + a.minPosstive());

		System.out.println("Dong co tong lon nhat: " + a.findMaxRow());

		System.out.println("Them dong vao dau jagged array: ");
		a.addRowFirst();
		a.Output();

		System.out.println("Them dong vao cuoi jagged array: ");
		a.addRowLast();
		a.Output();

		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap gia tri pos de them vao jagged array: ");
		int pos = sc.nextInt();
		System.out.println("Them dong vao vi tri pos jagged array: ");
		a.addRowPosition(pos);
		a.Output();

		System.out.print("Nhap gia vi tri dong can xoa tai jagged array: ");
		int pos2 = sc.nextInt();
		System.out.println("xoa dong tai vi tri pos jagged array: ");
		a.deleteRowPos(pos2);
		a.Output();

		int col = 1;
		System.out.println("Xoa cot thu " + col);
		a.deleteColPos(col);
		a.Output();

	}
}
