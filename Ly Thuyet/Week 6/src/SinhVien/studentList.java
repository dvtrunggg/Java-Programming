package SinhVien;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class studentList {
	private ArrayList<Student> list;

	public studentList() {
		list = new ArrayList();
	}

	public studentList(ArrayList<Student> list) {

		this.list = list;
	}

	public ArrayList<Student> getList() {
		return list;
	}

	public void setList(ArrayList<Student> list) {
		this.list = list;
	}

	final static String URL = "jdbc:mysql://localhost:3306/QLSinhVien";
	final static String USERNAME = "root";
	final static String PASSWORD = "Trung@123";
	final static String DRIVER = "com.mysql.cj.jdbc.Driver";

	public Connection getConnection() {
		try {
			Class.forName(DRIVER);
			System.out.println("Connecting to database...");
			Connection conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);

			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void Output() {
		for (Student st : list) {
			st.Output();
		}
	}

	public void findAll() {
		Connection conn = this.getConnection();
		try {
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();

			String SQL = "SELECT id, hoTen, ngaySinh, diaChi FROM SinhVien";
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				int id = rs.getInt("id");
				String hoTen = rs.getString("hoTen");
				String diaChi = rs.getString("diaChi");

				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				Date ngaySinh = new Date();
				java.sql.Date sqlDate = new java.sql.Date(ngaySinh.getTime());
				ngaySinh = rs.getDate("ngaySinh");


				String sDate = df.format(ngaySinh);
				Date newDate = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
				Student st = new Student(id, hoTen, newDate, diaChi);
				list.add(st);

				System.out.println("ID: " + id);
				System.out.println("Ho Ten: " + hoTen);
				System.out.println("Ngay Sinh: " + ngaySinh);
				System.out.println("Que Quan: " + diaChi);

			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println("Connect fail!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void Insert(Student st) {
		Connection conn = this.getConnection();

		try {
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();

			// convert javaTime (util) to sqlTime (sql.time)
			java.util.Date javaDate = st.getNgaySinh();
			long javaTime = javaDate.getTime();
			java.sql.Date sqlDate = new java.sql.Date(javaTime);

			String SQL = "insert into SinhVien" + "(id, hoTen, ngaySinh, diaChi)" + "values(" + st.getId() + ",'"
					+ st.getHoTen() + "','" + sqlDate + "','" + st.getdiaChi() + "')";

			stmt.executeUpdate(SQL);
			System.out.println("Insert Succesfully");

			list.add(st);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// delete theo id
	public void Delete(int id) {
		Connection conn = this.getConnection();

		try {
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();

			String SQL = "delete from SinhVien " + "where id = " + id;

			stmt.executeUpdate(SQL);
			System.out.println("Delete Succesfully\n");

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId() == id)
					list.remove(i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// delete theo object
	public void Delete(Student st) {
		Connection conn = this.getConnection();

		try {
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();

			String SQL = "delete from SinhVien " + "where id = " + st.getId();

			stmt.executeUpdate(SQL);
			System.out.println("Delete Succesfully");

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId() == st.getId())
					list.remove(i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Update(int id, int newID, String name, String sDate, String address) {
		Connection conn = this.getConnection();

		try {
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();

			Date date = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);

			// convert javaTime (util) to sqlTime (sql.time)
			java.util.Date javaDate = date;
			long javaTime = javaDate.getTime();
			java.sql.Date sqlDate = new java.sql.Date(javaTime);

			String SQL = "update SinhVien " + "set id = " + newID + ",hoTen = '" + name + "', ngaySinh = '" + sqlDate
					+ "',diaChi='" + address + "'" + "where id = " + id;

			stmt.executeUpdate(SQL);
			System.out.println("Update Succesfully");

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId() == id) {
					list.remove(i);

					Date newDate = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);
					Student st2 = new Student(newID, name, newDate, address);
					list.add(st2);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SearchByID(int id) {
		Connection conn = this.getConnection();

		try {
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();

			String SQL = "select * From SinhVien Where id = " + id;
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				String hoTen = rs.getString("hoTen");
				String diaChi = rs.getString("diaChi");
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				Date ngaySinh = new Date();
				java.sql.Date sqlDate = new java.sql.Date(ngaySinh.getTime());
				ngaySinh = rs.getDate("ngaySinh");

				System.out.println("ID: " + id);
				System.out.println("Ho Ten: " + hoTen);
				System.out.println("Ngay Sinh: " + ngaySinh);
				System.out.println("Dia Chi: " + diaChi);

			}

			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SearchByName(String name) {
		Connection conn = this.getConnection();

		try {
			System.out.println("Creating statement...");
			Statement stmt = conn.createStatement();

			String SQL = "select * From SinhVien Where hoTen = '" + name + "'";
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				int id = rs.getInt("id");
				String diaChi = rs.getString("diaChi");
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				Date ngaySinh = new Date();
				java.sql.Date sqlDate = new java.sql.Date(ngaySinh.getTime());
				ngaySinh = rs.getDate("ngaySinh");

				System.out.println("ID: " + id);
				System.out.println("Ho Ten: " + name);
				System.out.println("Ngay Sinh: " + ngaySinh);
				System.out.println("Dia Chi: " + diaChi);

			}

			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
