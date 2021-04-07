package Lab4_18126035;

import java.util.Scanner;

public class MachDon extends Mach {

	public MachDon() {
		super();
	}

	public void Input() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhap thiet bi: (1 - Den, 2 - Dien Tro, 3 - Tu dien): ");
		int choose = sc.nextInt();

		if (choose == 1) {
			this.Name = "Den";
			super.Input();
		}
		
		else if (choose == 2) {
			this.Name = "Dien Tro";
			super.Input();
		}
		
		else if (choose == 3) {
			this.Name = "Tu Dien";
			super.Input();
		}

	}
	

	
	public void Output()
	{
		super.Output();
	}

}
