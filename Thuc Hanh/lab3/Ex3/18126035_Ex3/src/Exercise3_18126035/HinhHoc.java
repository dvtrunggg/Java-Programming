package Exercise3_18126035;

abstract public class HinhHoc {
	protected String tenHinh;
	
	public HinhHoc()
	{
		tenHinh = "";
	}
	public String getTenHinh() {
		return tenHinh;
	}
	public void setTenHinh(String tenHinh) {
		this.tenHinh = tenHinh;
	}
	abstract void Input();
	abstract void Output();
	abstract double chuVi();
	abstract double dienTich();
	
}
