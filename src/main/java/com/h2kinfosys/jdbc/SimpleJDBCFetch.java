package com.h2kinfosys.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.mysql.cj.jdbc.Driver;

public class SimpleJDBCFetch {

	public static void main(String[] args) throws SQLException {
		// Driver
		String url = "jdbc:mysql://localhost:3306/sakila";
		String query = "select * from actor";
		Connection conn = null;
		try {
			
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, "root", "password");
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			if(rs!= null) {
				String firstName = null;
				String lastName = null;
				while(rs.next()) {
					int actorId = rs.getInt("actor_id");
					firstName = rs.getString("first_name");
					lastName = rs.getString("last_name");
					Timestamp ts = rs.getTimestamp("last_update");
					System.out.println(actorId + " " + firstName + " " + lastName + "  " + ts);
				}
			}
			
			System.out.println("Connection Test Successful");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) conn.close();
		}

	}

}
