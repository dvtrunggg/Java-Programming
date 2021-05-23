package TD7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class TD7_18126035 {

	public static void Output(int arr[]) {
		for (int i : arr) {
			System.out.print(i + "\t");

		}
		System.out.println();
	}

	public static void Addition(int arr1[], int arr2[], int size) {

		for (int i = 0; i < size; i++) {
			try {
				System.out.print(arr1[i] + arr2[i] + "\t");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("\nĐộ dài mảng không hợp lệ");

				System.out.println("Mảng 2 có độ dài = " + arr2.length + "; Mang 1 có độ dài = " + arr1.length);
				break;

			}
		}
	}

	public static void Soustraction(int arr1[], int arr2[], int size) {

		for (int i = 0; i < size; i++) {
			try {
				System.out.print(arr1[i] - arr2[i] + "\t");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("\nĐộ dài mảng không hợp lệ");

				System.out.println("Mảng 2 có độ dài = " + arr2.length + "; Mang 1 có độ dài = " + arr1.length);
				break;

			}
		}
	}

	public static void Multiplication(int arr1[], int arr2[], int size) {

		for (int i = 0; i < size; i++) {
			try {
				System.out.print(arr1[i] * arr2[i] + "\t");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("\nĐộ dài mảng không hợp lệ");

				System.out.println("Mảng 2 có độ dài = " + arr2.length + "; Mang 1 có độ dài = " + arr1.length);
				break;

			}
		}
	}

	public static void Devision(int arr1[], int arr2[], int size) {

		for (int i = 0; i < size; i++) {
			try {
				System.out.print(arr1[i] / arr2[i] + "\t");
			} catch (ArithmeticException ex) {
				System.out.print("infinity");

			}

			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("\nĐộ dài mảng không hợp lệ");

				System.out.println("Mảng 2 có độ dài = " + arr2.length + "; Mang 1 có độ dài = " + arr1.length);
				break;

			}
		}
	}

	public static void main(String[] args) {
		int arr1[] = { 1, 5, -2, 5, 8, 2 };
		int arr2[] = { 4, 7, 2, 12, 0 };


		
		
		
		System.out.print("arr1[] = ");
		Output(arr1);

		System.out.print("arr2[] = ");
		Output(arr2);

		Scanner sc = new Scanner(System.in);
		int size = Math.max(arr1.length, arr2.length);

		int i = 0, choose;
		do {
			try {
				System.out.println("Phep tinh tren 2 mang.");
				System.out.print("Chon: 1 - Phep Cong, 2 - Phep Tru, 3 - Phep Nhan, 4 - Phep Chia: ");
				choose = sc.nextInt();

				if (choose > 4 || choose < 1) {
					System.out.println("Sai syntax, moi nhap lai! ");
				}

			} catch (InputMismatchException e) {
				// e.printStackTrace();
				System.out.print("Nhap cac so tu 1 - 4 de lua chon chuc nang. Moi nhap lai: ");
				sc.nextLine();
				choose = sc.nextInt();

			}

			switch (choose) {
			case 1:
				Addition(arr1, arr2, size);
				break;
			case 2:
				Soustraction(arr1, arr2, size);
				break;
			case 3:
				Multiplication(arr1, arr2, size);
				break;
			case 4:
				Devision(arr1, arr2, size);
				break;
			default:
				break;
			}

		} while (choose > 4 || choose < 1);

	}
}
