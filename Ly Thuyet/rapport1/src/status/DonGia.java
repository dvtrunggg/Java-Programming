package status;

public class DonGia {
	private double giaDien, giaNuoc;

	public DonGia() {
		giaDien = 0;
		giaNuoc = 0;
	}

	public double getGiaDien() {
		return giaDien;
	}

	public void setGiaDien(double giaDien) {
		this.giaDien = giaDien;
	}

	public double getGiaNuoc() {
		return giaNuoc;
	}

	public void setGiaNuoc(double giaNuoc) {
		this.giaNuoc = giaNuoc;
	}

	public void updateGiaNuoc(double giaNuoc) {
		setGiaNuoc(giaNuoc);
	}

	public void updateGiaDien(double giaDien) {
		setGiaDien(giaDien);
	}

}
