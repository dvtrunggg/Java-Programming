//Bài tập 31.
//Viết chương trình để kiểm tra chuỗi có các ký tự duy nhất hay không?
//Ví dụ 01: input: "Green" à output: False
//Ví dụ 02: input: "Orange" à output: True

package lap1_18126035;

import java.util.Scanner;

public class Exercise31 {

	// kiểm tra chuỗi str có phải là duy nhất hay không (duy nhất khi các ký tự
	// trong chuỗi ko lặp lại)
	// return true nếu là chuỗi chứa các ký tự duy nhất (tạm gọi là chuỗi duy
	// nhất:))
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
//		System.out.print("Nhap chuoi can kiem tra co phai duy nhat (chuỗi chứa các ký tự duy nhất) hay ko: ");
//		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();

		String str = "Orange";
		// String str = "Green";

		System.out.println("Kiem tra co phai duy nhat (chuỗi chứa các ký tự duy nhất) hay ko: ");
		if (isUnique(str)) {
			System.out.println("True");
			System.out.println("\"" + str + "\"" + " la chuoi duy nhat");
		} else {
			System.out.println("False");
			System.out.println("\"" + str + "\"" + " khong phai la chuoi duy nhat");
		}
	}
}
