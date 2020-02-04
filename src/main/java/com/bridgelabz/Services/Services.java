package com.bridgelabz.Services;

import java.sql.SQLException;

import com.bridgelabz.model.Student;

public interface Services {
	public int create() throws SQLException;

	public int insert(Student student) throws SQLException;

	public int update(String id, Student student) throws SQLException;

	public int delete(String id) throws SQLException;

}
