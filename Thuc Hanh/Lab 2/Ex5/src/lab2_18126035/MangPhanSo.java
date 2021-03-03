package lab2_18126035;

import java.util.ArrayList;
import java.util.Scanner;

public class MangPhanSo {
	private int n;
	private ArrayList<PhanSo> fractionList;

	public MangPhanSo(int n, ArrayList<PhanSo> fractionList) {
		this.n = n;
		this.fractionList = fractionList;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public ArrayList<PhanSo> getFractionList() {
		return fractionList;
	}

	public void setFractionList(ArrayList<PhanSo> fractionList) {
		this.fractionList = fractionList;
	}

	public void inputList() {
		Scanner scanner = new Scanner(System.in);
		int size;
		System.out.print("Input size of array: ");
		size = Integer.parseInt(scanner.nextLine());
		this.setN(size);
		fractionList = new ArrayList<PhanSo>();
		for (int i = 0; i < this.n; i++) {
			PhanSo temp = new PhanSo();
			System.out.println("ps " + (i + 1));
			temp.inputFraction();
			fractionList.add(temp);
		}
		this.setFractionList(fractionList);
	}

	public void Print() {
		System.out.print("[ ");
		for (int i = 0; i < this.n; i++) {
			this.fractionList.get(i).outputFraction();
			System.out.print(" ");
		}
		System.out.print("]\n");
	}

	public PhanSo sumFractionList() {
		PhanSo result = this.fractionList.get(0);
		for (int i = 1; i < this.n; i++) {
			result = result.addFraction(this.fractionList.get(i));
		}
		return result;
	}

	public PhanSo productFractionList() {
		PhanSo result = this.fractionList.get(0);
		for (int i = 1; i < this.n; i++) {
			result = result.mulFraction(this.fractionList.get(i));
		}
		return result;
	}

	public PhanSo findMax() {
		PhanSo max = new PhanSo();
		max.setNumerator(this.fractionList.get(0).getNumerator());
		max.setDenominator(this.fractionList.get(0).getDenominator());
		for (int i = 1; i < this.n; i++) {
			if (max.getNumerator() * this.fractionList.get(i).getDenominator()
					- max.getDenominator() * this.fractionList.get(i).getNumerator() < 0) {
				max.setNumerator(this.fractionList.get(i).getNumerator());
				max.setDenominator(this.fractionList.get(i).getDenominator());
			}
		}
		return max;
	}

	public void findPostionOfMax() {
		PhanSo max = this.findMax();
		System.out.println("Positions of max:");
		for (int i = 0; i < this.n; i++) {
			if (max.getNumerator() == this.fractionList.get(i).getNumerator()
					&& max.getDenominator() == this.fractionList.get(i).getDenominator()) {
				System.out.print(i + "\n");
			}
		}
	}

	public void reduceFractionList() {
		for (int i = 0; i < n; i++) {
			this.fractionList.get(i).reduceFraction(fractionList.get(i));
		}
	}

	public void ascendingSort() {
		for (int i = 0; i < this.n; i++) {
			int indexMin = i;
			PhanSo min = new PhanSo();
			min.setNumerator(this.fractionList.get(i).getNumerator());
			min.setDenominator(this.fractionList.get(i).getDenominator());
			for (int j = i + 1; j < this.n; j++) {
				if (min.getNumerator() * this.fractionList.get(j).getDenominator()
						- min.getDenominator() * this.fractionList.get(j).getNumerator() > 0) {
					min.setNumerator(this.fractionList.get(j).getNumerator());
					min.setDenominator(this.fractionList.get(j).getDenominator());
					indexMin = j;
				}
			}
			PhanSo temp = new PhanSo();
			temp.setNumerator(this.fractionList.get(i).getNumerator());
			temp.setDenominator(this.fractionList.get(i).getDenominator());

			this.fractionList.get(i).setNumerator(this.fractionList.get(indexMin).getNumerator());
			this.fractionList.get(i).setDenominator(this.fractionList.get(indexMin).getDenominator());
			this.fractionList.get(indexMin).setNumerator(temp.getNumerator());
			this.fractionList.get(indexMin).setDenominator(temp.getDenominator());
		}

	}

	public void descendingSort() {
		for (int i = 0; i < this.n; i++) {
			int indexMax = i;
			PhanSo max = new PhanSo();
			max.setNumerator(this.fractionList.get(i).getNumerator());
			max.setDenominator(this.fractionList.get(i).getDenominator());
			for (int j = i + 1; j < this.n; j++) {
				if (max.getNumerator() * this.fractionList.get(j).getDenominator()
						- max.getDenominator() * this.fractionList.get(j).getNumerator() < 0) {
					max.setNumerator(this.fractionList.get(j).getNumerator());
					max.setDenominator(this.fractionList.get(j).getDenominator());
					indexMax = j;
				}
			}
			PhanSo temp = new PhanSo();
			temp.setNumerator(this.fractionList.get(i).getNumerator());
			temp.setDenominator(this.fractionList.get(i).getDenominator());
			this.fractionList.get(i).setNumerator(this.fractionList.get(indexMax).getNumerator());
			this.fractionList.get(i).setDenominator(this.fractionList.get(indexMax).getDenominator());
			this.fractionList.get(indexMax).setNumerator(temp.getNumerator());
			this.fractionList.get(indexMax).setDenominator(temp.getDenominator());
		}

	}

	public void updateFraction() {
		Scanner scanner = new Scanner(System.in);
		int k;
		System.out.print("Enter position of fraction to update: ");
		k = Integer.parseInt(scanner.nextLine());
		PhanSo update = new PhanSo();
		System.out.println("Enter fraction to update");
		update.inputFraction();
		this.fractionList.get(k).setFraction(update.getNumerator(), update.getDenominator());
	}

	public void addFraction() {
		Scanner scanner = new Scanner(System.in);
		int k;
		do {
			System.out.print("Enter position of fraction to add: ");
			k = Integer.parseInt(scanner.nextLine());
		} while (k < 0 || k >= this.n);
		PhanSo temp = new PhanSo();
		System.out.println("Enter fraction to add");
		temp.inputFraction();
		this.fractionList.add(k, temp);
		this.setN(this.n + 1);
	}

	public void deleteFraction() {
		Scanner scanner = new Scanner(System.in);
		int k;
		do {
			System.out.print("Enter position of fraction to delete: ");
			k = Integer.parseInt(scanner.nextLine());
		} while (k < 0 || k >= this.n);
		this.fractionList.remove(k);
		this.setN(this.n - 1);
	}

	public ArrayList<PhanSo> parseMangPhanSo(String strMangPhanSo) {

		String[] fractionList = strMangPhanSo.split(",");
		ArrayList<PhanSo> list = new ArrayList<PhanSo>();
		for (String item : fractionList) {
			PhanSo temp = new PhanSo();
			list.add(temp.parsePhanSo(item));
		}
		return list;
	}

}
