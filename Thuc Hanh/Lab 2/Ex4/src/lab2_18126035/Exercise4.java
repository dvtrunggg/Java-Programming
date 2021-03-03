package lab2_18126035;

public class Exercise4 {
	public static void main(String[] args) {
		
		
		PhanSo ps1 = new PhanSo();
		ps1.inputFraction();
		System.out.print("ps1 = : ");
		ps1.outputFraction();
		System.out.println();
		
		System.out.print("ps2 = : ");
		PhanSo ps2 = new PhanSo();
		ps2.setFraction(1, 3);
		ps2.outputFraction();
		System.out.println();
		
		PhanSo result = new PhanSo();
		System.out.print("ps1 + ps2 : ");
		result = ps1.addFraction(ps2);
		result.reduceFraction(result);
		result.outputFraction();
		System.out.println();
		
		
		System.out.print("ps1 - ps2 : ");
		result = ps1.subFraction(ps2);
		result.outputFraction();
		System.out.println();
		
		
		System.out.print("ps1 * ps2 : ");
		result = ps1.mulFraction(ps2);
		result.reduceFraction(result);
		result.outputFraction();
		System.out.println();
		
		
		System.out.print("ps1 / ps2 : ");
		result = ps1.devideFraction(ps2);
		result.reduceFraction(result);
		result.outputFraction();
		System.out.println();
	}
}
