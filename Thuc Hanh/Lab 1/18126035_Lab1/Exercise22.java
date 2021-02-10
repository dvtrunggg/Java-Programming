//Viet chuong trinh xay dung Linked List (danh sach lien ket). Sau do, thuc hien dao nguoc danh
//sach lien ket nay.
//Vi du: nhap vao 20 -> 40 -> 60 -> 80, danh sach dao nguoc 80 -> 60 -> 40 -> 20.

//package lap1_18126035;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercise22 {

	// ham input value cho cac node
	public static void Input(LinkedList<Integer> list, int n, Scanner sc) {
		for (int i = 0; i < n; i++) {
			System.out.print("Node " + i + ": ");
			int value = sc.nextInt();
			list.add(value);
		}
	}

	// ham print value cac node trong list
	public static void Output(LinkedList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
	}

	// cach 1: ham dao nguoc list: tao 1 list moi roi add head vao tu list cu
	public static LinkedList<Integer> Reverse(LinkedList<Integer> list) {
		LinkedList<Integer> listReverse = new LinkedList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			int value = list.get(i);
			listReverse.addFirst(value);
		}
		return listReverse;
	}

	// cach 2: ham dao nguoc list: dung Iterator
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
