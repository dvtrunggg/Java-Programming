package TD5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TD5_18126035 {
	public static void main(String[] args) throws IOException {

		int f1, f2;

		FileInputStream fin1 = null, fin2 = null;

		// list1 contains the ASCII code of file 1
		ArrayList<Integer> list1 = new ArrayList<>();

		// list2 contains the ASCII code of file 2
		ArrayList<Integer> list2 = new ArrayList<>();

		if (args.length < 1) {
			System.out.println("Usage: Copy File From to");
			return;
		}

		try {
			fin1 = new FileInputStream(args[0]);
			fin2 = new FileInputStream(args[1]);

			do {
				f1 = fin1.read();
				list1.add(f1);

			} while (f1 != -1);

			do {
				f2 = fin2.read();
				list2.add(f2);
			} while (f2 != -1);

		} catch (IOException exc) {
			System.out.println("I/O error: " + exc);
		} finally {
			try {
				if (fin1 != null)
					fin1.close();

				if (fin2 != null)
					fin2.close();

			} catch (IOException exc) {
				System.out.println("Error closing input file");
			}

		}

		System.out.println();
		System.out.println(list1);
		System.out.println(list2);

		int size = Math.max(list1.size(), list2.size());
		System.out.print("file1 and file2 is different at index: ");

		for (int i = 0; i < size; i++) {
			if (list1.get(i) != list2.get(i)) {
				System.out.print(" " + i);
			}
		}

		// ko phan biet in hoa va in thuong
		System.out.println("Khong phan biet in hoa va in thuong");
		for (int i = 0; i < size; i++) {
			if (list1.get(i) >= 97) {
				list1.add(list1.get(i) - 32);

			}
			if (list2.get(i) >= 97) {
				list2.add(list2.get(i) - 32);

			}
			if (list1.get(i) != list2.get(i)) {
				System.out.print(" " + i);
			}
		}

	}
}
