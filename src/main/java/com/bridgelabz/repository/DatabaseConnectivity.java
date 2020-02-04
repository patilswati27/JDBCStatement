package com.bridgelabz.repository;

import java.sql.*;

public class DatabaseConnectivity {
	static String url = "jdbc:mysql://localhost:3306/School";
	static String username = "root";
	static String password = "admin@123";
	static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // load and register driver
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

}
