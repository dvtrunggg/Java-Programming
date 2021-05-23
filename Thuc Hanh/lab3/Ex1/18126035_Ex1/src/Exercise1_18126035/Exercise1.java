package Exercise1_18126035;



public class Exercise1 {
	public static void main(String[] args) {
		TrungTamTinHoc tt = new TrungTamTinHoc();
		System.out.println("Welcome to Trung Tam Tin Hoc :))");
		System.out.println("Enter List Teacher\n");
		tt.Input();
		
		System.out.println("--------List Teacher-------");
		tt.Output();
		System.out.println();
		
		System.out.println("-------List Giang Vien Thinh Giang--------");
		tt.OutputGVThinhGiang();
		System.out.println();
		
		System.out.println("-------List Giang Vien Co Huu--------");
		tt.OutputGVCoHuu();
		System.out.println();
		
		System.out.println("Sum of Salary that Computer Center have to pay: " + tt.tongLuong());

		
		System.out.print("Type of Teacher has highest salary: ");
		tt.loaiGiangVien();
		


	}
}
