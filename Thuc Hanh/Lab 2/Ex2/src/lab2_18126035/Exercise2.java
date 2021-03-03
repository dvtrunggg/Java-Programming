package lab2_18126035;

public class Exercise2 {
	public static void main(String[] args) {
		int lazy[][] = { { 2, 1, 5, 21 }, { 20, 4, 0, -2 }, { -5, 3, -10, -15 }, { 11, -22, 17, -13 } };
	
		MangHaiChieu a = new MangHaiChieu(lazy);
		
		//a.Input();
		a.Output();

		a.sortAscRow();
		a.Output();

		a.sortDescCol();
		a.Output();

		System.out.println("Phan tu duong lon nhat: "+ a.findMinPositive());
		System.out.println("Phan tu am lon nhat: "+ a.findMaxNegative());

		System.out.println("Max dong: "+a.findMaxRow());
		System.out.println("Max cot: "+a.findMaxCol());

		System.out.println("Add dong dau tien");
		a.addRowFirst();
		a.Output();
		
		System.out.println("Add dong cuoi cung");
		a.addRowLast();
		a.Output();
		
		int pos = 2;
		System.out.println("Add dong vao vi tri"+ " pos: ");
		a.addRowPosition(pos);
		a.Output();
		
		System.out.println("xoa dong "+ pos + ": ");
		a.removeRow(2);
		a.Output();
		
		System.out.println("xoa cot "+ pos + ": ");
		a.removeCol(2);
		a.Output();
		

	}
}
