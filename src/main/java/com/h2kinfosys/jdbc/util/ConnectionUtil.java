package com.h2kinfosys.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class ConnectionUtil {
	
	static String url = "jdbc:mysql://localhost:3306/sakila";
	static String userId = "root";
	static String password =  "password";
	
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties props = new Properties();
		props.setProperty("user", userId);
		props.setProperty("password", password);
		Connection conn = DriverManager.getConnection(url, props);
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}

}
