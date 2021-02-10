//Bai tap 31.
//Viet chuong trinh de kiem tra chuoi co cac ky tu duy nhat hay khong?
//Vi du 01: input: "Green" a output: False
//Vi du 02: input: "Orange" a output: True

//package lap1_18126035;

import java.util.Scanner;

public class Exercise31 {

	// kiem tra chuoi str co phai la duy nhat hay khong (duy nhat khi cac ky tu
	// trong chuoi ko lap lai)
	// return true neu la chuoi chua cac ky tu duy nhat (tam goi la chuoi duy
	// nhat:))
	public static boolean isUnique(String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
//		System.out.print("Nhap chuoi can kiem tra co phai duy nhat (chuoi chua cac ky tu duy nhat) hay ko: ");
//		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();

		String str = "Orange";
		// String str = "Green";

		System.out.println("Kiem tra co phai duy nhat (chuoi chua cac ky tu duy nhat) hay ko: ");
		if (isUnique(str)) {
			System.out.println("True");
			System.out.println("\"" + str + "\"" + " la chuoi duy nhat");
		} else {
			System.out.println("False");
			System.out.println("\"" + str + "\"" + " khong phai la chuoi duy nhat");
		}
	}
}
