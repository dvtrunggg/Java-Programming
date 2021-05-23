//Viết chương trình xây dựng Linked List (danh sách liên kết). Sau đó, thực hiện đảo ngược danh
//sách liên kết này.
//Ví dụ: nhập vào 20 -> 40 -> 60 -> 80, danh sách đảo ngược 80 -> 60 -> 40 -> 20.

package lap1_18126035;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercise22 {

	// hàm input value cho các node
	public static void Input(LinkedList<Integer> list, int n, Scanner sc) {
		for (int i = 0; i < n; i++) {
			System.out.print("Node " + i + ": ");
			int value = sc.nextInt();
			list.add(value);
		}
	}

	// hàm print value các node trong list
	public static void Output(LinkedList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
	}

	// cách 1: hàm đảo ngược list: tạo 1 list mới rồi add head vào từ list cũ
	public static LinkedList<Integer> Reverse(LinkedList<Integer> list) {
		LinkedList<Integer> listReverse = new LinkedList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			int value = list.get(i);
			listReverse.addFirst(value);
		}
		return listReverse;
	}

	// cách 2: hàm đảo ngược list: dùng Iterator
	public static LinkedList<Integer> Reverse2(LinkedList<Integer> list) {
		LinkedList<Integer> listReverse = new LinkedList<Integer>();
		Iterator<Integer> re = list.descendingIterator();
		while (re.hasNext()) {
			listReverse.add(re.next());
		}

		return listReverse;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhap so luong node trong list: ");
		int n = sc.nextInt();

		LinkedList<Integer> list = new LinkedList<Integer>();
		System.out.println("Nhap gia tri cac node: ");
		Input(list, n, sc);
		Output(list);

		LinkedList<Integer> listReverse = Reverse(list);
		System.out.println("\nReverse List: ");
		Output(listReverse);

	}
}
