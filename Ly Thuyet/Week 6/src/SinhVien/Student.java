package SinhVien;

//import java.sql.Date;
import java.util.UUID;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	private int id;
	private String hoTen;
	private Date ngaySinh;
	private String diaChi;

	public Student(int id, String hoTen, Date ngaySinh, String diaChi) {

		this.id = id;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}

//	// convert string to date
//	public static Date Convert(String str) {
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
//		try {
//			date = sdf.parse(str);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		return date;
//
//	}

	public Student() {
//		UUID uuid = UUID.randomUUID();
//		this.id = uuid.toString().replace("-", "").substring(0, 8);
		this.id = 0;
		this.hoTen = "";
		this.ngaySinh = new Date();
		this.diaChi = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getdiaChi() {
		return diaChi;
	}

	public void setdiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public void Output() {
		System.out.println("ID: " + id + "\t Ho ten: " + hoTen);
		System.out.println("Ngay Sinh: " + ngaySinh + " Dia Chi: " + diaChi);
	}

}
