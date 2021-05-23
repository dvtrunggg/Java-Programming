package test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class testFinnally {
	public static void genException(int what) {
		int t, num[] = new int[2];
		System.out.println("Receiving " + what);
		
		try {
			switch(what) {
			case 0: t = 10/what; break;
			case 1: num[4] = 4; break;
			case 2: return;
			}
		} catch (ArithmeticException exc) {
			System.out.println("can't divide by zero!");
			return;
		}catch(ArrayIndexOutOfBoundsException exc) {
			System.out.println("No matching element found");
		}finally {
			System.out.println("Leaving try.");
		}
	}
	
	
	public static void main(String[] args) {
//		for(int i = 0; i<3; i++)
//		{
//			testFinnally.genException(i);
//			System.out.println();
//		}
		
		
		Scanner sc = new Scanner(System.in);
		int choose;

		try {
		System.out.println("Phep tinh tren 2 mang.");
		System.out.print("Chon: 1 - Phep Cong, 2 - Phep Tru, 3 - Phep Nhan, 4 - Phep Chia: ");
		choose = sc.nextInt();

		if (choose > 4 || choose < 1) {
			System.out.println("Sai syntax, moi nhap lai! ");
		}
System.out.println("123");
		}catch(InputMismatchException e) {
			//e.printStackTrace();
			//System.out.print("Nhap cac so tu 1 - 4 de lua chon chuc nang. Moi nhap lai: ");
			System.out.println("sdc");
			sc.nextLine();

		}
	}
	
}
