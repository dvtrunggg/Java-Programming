//Bài tập 29.
//Viết chương trình để tìm ra số đường có thể leo lên đỉnh của một ngọn đồi (với n bước để lên
//tới đỉnh đồi). Với mỗi lần di chuyển, chúng ta chỉ có thể thực hiện 1 hoặc 2 bước.
//Ví dụ:
//- Input: n = 5
//- Sẽ có các con đường:
//- 1 + 1 + 1 + 1 + 1 = 5
//- 1 + 1 + 1 + 2 = 5
//- 1 + 2 + 2 = 5
//- 2 + 1 + 2 = 5
//- 2 + 2 + 1 = 5
//- 1 + 1 + 2 + 1 = 5
//- 1 + 2 + 1 + 1 = 5
//- 2 + 1 + 1 + 1 = 5
//- Outout: Số đường để lên đỉnh đồi là 8

package lap1_18126035;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise29 {
	// khai báo biến global n để tiện sử dụng. count là Output: số đường lên đỉnh đồi
	public static int n;
	public static int count = 0;

	// hàm in ra biểu thứ + cho array list. vd: (n=5) -> 5 = 2 + 2 + 1, .....
	public static void Print(ArrayList<Integer> list) {
		System.out.print(n + " = ");
		for (int i = 0; i < list.size(); i++) {
			if (i > 0)
				System.out.print(" + " + list.get(i));
			else
				System.out.print(list.get(i));
		}
	}

	// in ra tất cả các con đường lên đỉnh đồi:
	// in ra các trường hợp n = tổng các số 1 và 2: vd với n = 3 thì 3 = 1+1+1;
	// 3=1+2; 3=2+1
	// đếm các trường hợp và lưu vào biến count
	public static void duongLenDinhDoi(int n, ArrayList<Integer> list) {
		//n == 0 nghĩa là các tổng các giá trị i đã = n -> print ra trường hợp đó
		if (n == 0) {
			count++;
			Print(list);
			System.out.println();
		}

		//nếu n>0 thì cứ trừ tiếp và gọi đệ quy cho đến khi n == 0
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
