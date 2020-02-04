package com.bridgelabz.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.model.Student;
import com.bridgelabz.repository.DatabaseConnectivity;

public class ServiceImplementation implements Services {
	static Connection con = DatabaseConnectivity.getConnection();
	static Statement statement = null;

	/**
	 * Purpose: method for creating table into database using statement
	 * 
	 * @throws SQLException
	 */
	public int create() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS student" + "(id int primary key," + "name varchar(50),"
				+ "address varchar(100)," + "Email varchar(100));";
		statement = con.createStatement();
		return statement.executeUpdate(sql);
	}

	/**
	 * Purpose: method for inserting table into database using statement
	 * 
	 * @throws SQLException
	 */
	public int insert(Student student) throws SQLException {
		String query = "insert into student values(" + student.getId() + ",'" + student.getName() + "','"
				+ student.getAddress() + "','" + student.getEmail() + "')";
		statement = con.createStatement();
		return statement.executeUpdate(query);
	}

	/**
	 * Purpose: method for updating table into database using statement
	 * 
	 * @throws SQLException
	 */
	public int update(String id, Student student) throws SQLException {
		String query = "Update student set name='" + student.getName() + "', address='" + student.getAddress()
				+ "' WHERE id=" + id + "";
		statement = con.createStatement();
		return statement.executeUpdate(query);

	}

	/**
	 * Purpose: method for deleting table into database using statement
	 * 
	 * @throws SQLException
	 */
	public int delete(String id) throws SQLException {
		String query = "Delete from student where id='" + id + "'";
		statement = con.createStatement();
		return statement.executeUpdate(query);

	}

	public void showRecords() throws SQLException {
		String query = "Select * from student";
		statement = con.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {
			System.out.println("Id" + ":" + rs.getInt("id") + "\t" + " Name" + ": " + rs.getString("name") + "\t"
					+ " Address" + ":" + rs.getString(3) + "\t" + "Email" + ":" + rs.getString("Email"));
			System.out.println();
		}
	}
}
