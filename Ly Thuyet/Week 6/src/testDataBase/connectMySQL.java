package testDataBase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;


public class connectMySQL {
	private final static String URL = "jdbc:mysql://localhost:3306";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Trung@123";
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {

		try {

			Class.forName(DRIVER);
			Connection conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);

//			if (conn != null) {
//				DatabaseMetaData dm = (DatabaseMetaData) ((java.sql.Connection) conn).getMetaData();
//				System.out.println("Driver name: " + dm.getDriverName());
//				System.out.println("Driver version: " + dm.getDriverVersion());
//				System.out.println("Product name: " + dm.getDatabaseProductName());
//				System.out.println("Product version: " + dm.getDatabaseProductVersion());
//
//			}
			
			conn.setAutoCommit(false);
			Statement stmt = (Statement) conn.createStatement();
			String SQL = ""

		} catch (ClassNotFoundException e) {
			System.out.println("Không tìm thấy Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Sai thông tin kết nối db!");
			e.printStackTrace();
		}

	}
}
