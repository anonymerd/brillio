package com.testJDBC;

import java.sql.SQLException;
import java.util.Scanner;


public class App {
	public static void main(String[] args) throws SQLException {
		try {
			App.save();
//			App.update();
//			App.delete();
			App.getAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Connection Closed!!");
			Utility.closeConnection();
		}
		
	}
	
	private static void save() throws SQLException {
		System.out.println("Save Employee");
		Scanner scanner = new Scanner(System.in);
		Employee emp = new Employee();
		System.out.println("Emp ID: ");
		emp.setId("" + scanner.nextInt());
		System.out.println("Emp Name: ");
		emp.setName(scanner.next());
		System.out.println("Emp Salary: ");
		emp.setSalary(scanner.nextInt());
		scanner.close();
		DAO.saveEmployee(emp);

	}

	private static void getAll() throws SQLException {
		DAO.getAllEmployees();
	}

	private static void update() throws SQLException {
		System.out.println("Update Employee");
		Scanner scanner = new Scanner(System.in);
		Employee emp = new Employee();
		System.out.println("Emp ID: ");
		emp.setId("" + scanner.nextInt());
		System.out.println("Emp Name: ");
		emp.setName(scanner.next());
		System.out.println("Emp Salary: ");
		emp.setSalary(scanner.nextInt());
		scanner.close();
		DAO.updateEmployee(emp);
	}
	private static void delete() throws SQLException {
		System.out.println("Delete Employee");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Emp ID: ");
		String empId =scanner.next();
		scanner.close();
		DAO.deleteEmployee(empId);
		
	}
}
