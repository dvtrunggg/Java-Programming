package Lab4_18126035;

public class Exercise2 {
	public static void main(String[] args) {
		MachDien md = new MachDien();
		md.Input();
		System.out.println("danh sach mach dien: ");
		md.Output();
		
		// ghi file
		md.writeFile("MachDien.data");
	}
}
