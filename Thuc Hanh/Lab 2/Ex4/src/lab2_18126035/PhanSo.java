package lab2_18126035;

import java.util.Scanner;

public class PhanSo {
	private int num; //numinator
	private int deno; //deno

	// Constructor
	public PhanSo(int num, int deno) {
		this.num = num;
		this.deno = deno;
	}

	public PhanSo() {
		this.num = 1;
		this.deno = 1;
	}

	// Getter, setter methods
	public int getNumerator() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDenominator() {
		return deno;
	}

	public void setDenominator(int deno) {
		this.deno = deno;
	}

	public void setFraction(int num, int deno) {
		this.num = num;
		this.deno = deno;
	}

	// Input - enter a fraction
	public void inputFraction() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter numinator: ");
		this.num = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter denominator: ");
		this.deno = Integer.parseInt(scanner.nextLine());
	}

	// Output - display a fraction
	public void outputFraction() {
		System.out.print(this.num + "/" + this.deno);
	}

	public PhanSo addFraction(PhanSo _fraction) {
		PhanSo result = new PhanSo();
		result.num = this.num * _fraction.deno + _fraction.num * this.deno;
		result.deno = this.deno * _fraction.deno;
		return result;
	}

	public PhanSo addFraction(PhanSo fraction, PhanSo _fraction) {
		this.num = fraction.num * _fraction.deno + _fraction.num * fraction.deno;
		this.deno = fraction.deno * _fraction.deno;
		return this;
	}

	public PhanSo subFraction(PhanSo _fraction) {
		PhanSo result = new PhanSo();
		result.num = this.num * _fraction.deno - _fraction.num * this.deno;
		result.deno = this.deno * _fraction.deno;
		return result;
	}

	public PhanSo subFraction(PhanSo fraction, PhanSo _fraction) {
		this.num = fraction.num * _fraction.deno - _fraction.num * fraction.deno;
		this.deno = fraction.deno * _fraction.deno;
		return this;
	}

	public PhanSo mulFraction(PhanSo _fraction) {
		PhanSo result = new PhanSo();
		result.num = this.num * _fraction.num;
		result.deno = this.deno * _fraction.deno;
		return result;
	}

	public PhanSo mulFraction(PhanSo fraction, PhanSo _fraction) {
		this.num = fraction.num * _fraction.num;
		this.deno = fraction.deno * _fraction.deno;
		return this;
	}

	public PhanSo devideFraction(PhanSo _fraction) {
		PhanSo result = new PhanSo();
		if (this.deno != 0 && _fraction.deno != 0) {
			result.num = this.num * _fraction.deno;
			result.deno = this.deno * _fraction.num;
		} else {
			result.num = 0;
			result.deno = 1;
		}
		return result;
	}

	public void reduceFraction(PhanSo result) {
		int n1 = result.num;
		int n2 = result.deno;
		while (n1 != n2) {
			if (n1 > n2)
				n1 = n1 - n2;
			else
				n2 = n2 - n1;
		}
		if (n1 != 0) {
			result.num = this.num / n1;
			result.deno = this.deno / n1;
		}
	}

	public PhanSo parsePhanSo(String fractionStr) {
		int i = 0;
		while (i < fractionStr.length()) {
			if (fractionStr.charAt(i) == '/') {
				this.num = Integer.parseInt(fractionStr, 0, i, 10);
				this.deno = Integer.parseInt(fractionStr, i + 1, fractionStr.length(), 10);
				break;
			}
			i++;
		}
		return this;
	}
}
