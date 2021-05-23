package lab2_18126035;

import java.util.ArrayList;

public class Exercise5 {
	public static void main(String[] args) {
		MangPhanSo list = new MangPhanSo(10, null);
		list.inputList();
		list.Print();
		PhanSo sum = list.sumFractionList();
		System.out.print("Sum of list: ");
		sum.outputFraction();
		System.out.println();

		PhanSo product = list.productFractionList();
		System.out.print("Product of list: ");
		product.outputFraction();
		System.out.println();

		PhanSo max = list.findMax();
		System.out.print("Max of list: ");
		max.outputFraction();
		System.out.println();

		list.findPostionOfMax();
		System.out.print("Reduced fraction list: ");
		list.reduceFractionList();
		list.Print();
		System.out.println("Fraction list in ascending order: ");

		list.ascendingSort();
		list.Print();
		System.out.println("Fraction list in descending order: ");
		list.descendingSort();
		list.Print();

		list.updateFraction();
		list.Print();
		list.addFraction();

		list.Print();
		list.deleteFraction();
		list.Print();
		MangPhanSo list1 = new MangPhanSo(10, null);
		ArrayList<PhanSo> list2 = new ArrayList<PhanSo>();
		System.out.println("Fraction parsed from a given string");
		
		String fraction = "3/4,2/5,1/2";
		list2 = list1.parseMangPhanSo(fraction);
		for (PhanSo item : list2) {
			System.out.println(item.getNumerator() + "/" + item.getDenominator());
		}
	}
}
