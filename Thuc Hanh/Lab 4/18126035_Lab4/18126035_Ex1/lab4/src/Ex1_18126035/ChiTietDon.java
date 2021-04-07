package Ex1_18126035;

public class ChiTietDon extends ChiTiet {
	public ChiTietDon() {
		super();
		this.Name = "Chi Tiet Don";
	}

	public ChiTietDon(String maChiTiet, String name, int giaTien) {
		super(maChiTiet, name, giaTien);
	}

	public void Input() {
		super.Input();
	}

	public void Output() {
		super.Output();
	}

	public void Output2() {
		super.Output();
	}
	public int tinhTien() {
		return this.giaTien;
	}

	public String Inf() {
		return this.Name + "," + this.maChiTiet + "," + this.giaTien;
	}

}
