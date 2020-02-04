package com.bridgelabz.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.Services.ServiceImplementation;
import com.bridgelabz.model.Student;

public class MainClass {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		ServiceImplementation impl = new ServiceImplementation();

		boolean exit = false;
		while (!exit) {
			System.out.println("1. Create table\n2. Insert value\n3. Update value\n4. Delete value\n5. Show records\n6. exit");
			System.out.println("Enter your choice ");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("Creating Table ");
		     	if (impl.create() != 0) {
					System.out.println("Table already exist");
				}else {
				System.out.println("Table created succesfully");
				}
				break;

			case 2:
				System.out.println("********Inserting data********** ");
				System.out.println("Enter Id ");
				student.setId(sc.next());
				System.out.println("Enter name ");
				student.setName(sc.next());
				System.out.println("Enter address");
				student.setAddress(sc.next());
				System.out.println("Enter Email id");
				student.setEmail(sc.next());

				System.out.println("Row's Affected " +impl.insert(student));
				break;

			case 3:
				System.out.println("updating table");
				System.out.println("Enter Id you want to update");
				String id = sc.next();
				System.out.println("Enter name to update");
				student.setName(sc.next());
				System.out.println("Enter address to update");
				student.setAddress(sc.nextLine());

				System.out.println("Rows updated :" + impl.update(id, student));
				break;

			case 4:
				System.out.println("Delete data");
				System.out.println("enter Id you want to delete");
				String id1 = sc.next();
				System.out.println("Row's Affected :" + impl.delete(id1));
				break;

			case 5:
				System.out.println("Records");
				impl.showRecords();
				break;

			case 6:
				exit = true;
				break;

			default:
				System.out.println("Invalid input ");
			}
		}
		sc.close();
	}

}
