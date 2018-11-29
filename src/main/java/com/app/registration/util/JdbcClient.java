package com.app.registration.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcClient {

	private static Connection connection;

	private static final String DRIVER_CLASS_NAME = "oracle.jdbc.driver.OracleDriver";

	private JdbcClient() {	}

	static {
		try {
			Class.forName(DRIVER_CLASS_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {			
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","India");
    }
	
	public static void testConnection() throws SQLException {
		if(getConnection()!=null) {
			System.out.println("Database connection successful!");
		} else {
			System.out.println("Database connection unsuccessful!");
		}
		
	}

}
