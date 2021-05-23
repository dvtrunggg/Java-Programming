package lab2_18126035;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise01 {
	public static void main(String[] args) {
		int b[] = { 6, -12, 2, 1, 9 };
		int c[] = { -12, -6, -12, -2, -9 };
		int d[] = { 6, 12, 2, 1, 9 };
		MangSoNguyen a = new MangSoNguyen(5);

		System.out.println(a.getLen());
		// a.Input();

		a.setA(c);

		System.out.println("Your array: ");
		a.Output();

		System.out.print("Acsending sort array: ");
		a.acsendingSort();
		a.Output();

		System.out.print("Decsending sort array: ");
		a.decsendingSort();
		a.Output();

		System.out.println("Sum of element in array: " + a.Sum());
		System.out.println("Tich cac phan tu trong mang: " + a.Multiplication());

		System.out.println("The largest element in array: " + a.Max());

		if (a.maxNegative() > 0)
			System.out.println("Array has no negative element!");
		else
			System.out.println("The largest negative element in array: " + a.maxNegative());

		if (a.minPosstive() < 0)
			System.out.println("Array has no positive element!");
		else
			System.out.println("The smallest positive element in array: " + a.minPosstive());

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter value for adding head: ");
		int value1 = sc.nextInt();
		System.out.print("Add " + value1 + " to head: ");
		a.addHead(value1);
		a.Output();

		System.out.print("Enter value for adding tail: ");
		int value2 = sc.nextInt();
		System.out.print("add " + value2 + "to tail: ");
		a.addTail(value2);
		a.Output();

		System.out.print("Enter value: ");
		int value3 = sc.nextInt();
		System.out.print("Enter postion: ");
		int pos = sc.nextInt();
		System.out.print("add " + value3 + " to postion " + pos + ": ");
		a.addPostion(value3, pos);
		a.Output();

		System.out.println("Delete element from postion.");
		System.out.print("Enter postion: ");
		int pos2 = sc.nextInt();
		System.out.print("Delete element at postion " + pos2 + ": ");
		a.deletePostion(pos2);
		a.Output();

		System.out.print("Enter value: ");
		int value4 = sc.nextInt();
		System.out.print("Delete element " + value4 + ": ");
		a.deleteElement(value4);
		a.Output();

		System.out.print("Enter value: ");
		int value5 = sc.nextInt();
		System.out.print("Enter postion: ");
		int pos3 = sc.nextInt();
		System.out.print("Update element " + value5 + ": at position " + pos3 + ": ");
		a.Update(value5, pos3);
		a.Output();

		System.out.println("Update value: ");
		System.out.print("Enter old value: ");
		int x = sc.nextInt();
		System.out.print("Enter new value: ");
		int y = sc.nextInt();
		System.out.print("Update element " + x + ": to " + y + ": ");
		a.updateValue(x, y);
		a.Output();

		System.out.print("Convert String to int[]: ");
		int arr[] = a.parseMangSoNguyen("1,2,3;4 5");
		System.out.println(Arrays.toString(arr));

	}
}
