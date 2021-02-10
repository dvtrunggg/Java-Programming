//Bai tap 29.
//Viet chuong trinh de tim ra so duong co the leo len dinh cua mot ngon doi (voi n buoc de len
//toi dinh doi). Voi moi lan di chuyen, chung ta chi co the thuc hien 1 hoac 2 buoc.
//Vi du:
//- Input: n = 5
//- Se co cac con duong:
//- 1 + 1 + 1 + 1 + 1 = 5
//- 1 + 1 + 1 + 2 = 5
//- 1 + 2 + 2 = 5
//- 2 + 1 + 2 = 5
//- 2 + 2 + 1 = 5
//- 1 + 1 + 2 + 1 = 5
//- 1 + 2 + 1 + 1 = 5
//- 2 + 1 + 1 + 1 = 5
//- Outout: So duong de len dinh doi la 8

//package lap1_18126035;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise29 {
	// khai bao bien global n de tien su dung. count la Output: so duong len dinh doi
	public static int n;
	public static int count = 0;

	// ham in ra bieu thu + cho array list. vd: (n=5) -> 5 = 2 + 2 + 1, .....
	public static void Print(ArrayList<Integer> list) {
		System.out.print(n + " = ");
		for (int i = 0; i < list.size(); i++) {
			if (i > 0)
				System.out.print(" + " + list.get(i));
			else
				System.out.print(list.get(i));
		}
	}

	// in ra tat ca cac con duong len dinh doi:
	// in ra cac truong hop n = tong cac so 1 va 2: vd voi n = 3 thi 3 = 1+1+1;
	// 3=1+2; 3=2+1
	// dem cac truong hop va luu vao bien count
	public static void duongLenDinhDoi(int n, ArrayList<Integer> list) {
		//n == 0 nghia la cac tong cac gia tri i da = n -> print ra truong hop do
		if (n == 0) {
			count++;
			Print(list);
			System.out.println();
		}

		//neu n>0 thi cu tru tiep va goi de quy cho den khi n == 0
		else {
			for (int i = 1; i <= 2; i++) {
				if (n - i >= 0) {
					ArrayList<Integer> listTemp = new ArrayList<Integer>(list);
					listTemp.add(i);
					duongLenDinhDoi(n - i, listTemp);
				}
			}
		}
	}

	public static void main(String[] args) {
//		System.out.print("Nhap n: ");
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
		
		n = 5;
		ArrayList<Integer> list = new ArrayList<Integer>();
		duongLenDinhDoi(n, list);
		System.out.println("Output: So duong len dinh doi: " + count);

		
	}

}
