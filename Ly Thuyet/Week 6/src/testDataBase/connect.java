package testDataBase;

import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;

public class connect {
	
	public static final String DB_URL = "jdbc:sqlserver://localhost;";
	// Database credentials
	public static final String USER = "trung";
	public static final String PASS = "123";
	
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			
			Connection conn = (Connection) DriverManager.getConnection(DB_URL,USER, PASS);
			
			if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) ((java.sql.Connection) conn).getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }

		} catch (SQLException ex) {
			System.out.println("Error: Unable to load driver class.");
			System.exit(1);
		}
	
		
	}
}
