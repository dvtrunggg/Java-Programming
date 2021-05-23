package com.group5.conn;

import com.group5.constants.dbConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    public static Connection getConnection() {
        try {
            Class.forName(dbConstants.DRIVER);
            Connection conn = DriverManager.getConnection(dbConstants.URL, dbConstants.USERNAME, dbConstants.PASSWORD);
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("Not found Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Wrong infomation connect Database !");
            e.printStackTrace();
        }

        return null;
    }

}
