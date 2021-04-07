package Ex1_18126035;

//doi tuong la 1 chi tiet phuc (chi tiet phuc thanh phan)
public class MotChiTietPhuc extends ChiTiet {
	public MotChiTietPhuc() {
		super();
		this.Name = "Chi Tiet Thanh Phan Phuc";

	}

	public MotChiTietPhuc(String maChiTiet, String name, int giaTien) {
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
		return giaTien;
	}

	public String Inf() {
		return this.Name + "," + this.maChiTiet + "," + this.giaTien;
	}
}
