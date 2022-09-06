package com.testJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO{
	static Connection conn = null;
	
	static void saveEmployee(Employee emp) throws SQLException {
		conn = Utility.createConnection();
		String sql = "insert into emp values(?, ?, ?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, emp.getId());
		statement.setString(2, emp.getName());
		statement.setInt(3, emp.getSalary());
		int count = statement.executeUpdate();
		
		System.out.println("Employee added " + count);
	}
	
	static void getAllEmployees() throws SQLException {
		conn = Utility.createConnection();
		Statement statement = conn.createStatement();
		String sql = "select * from emp";
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			System.out.println("Emp ID: " + rs.getString("id") + " Emp Name: " + rs.getString("name") + " Emp Salary: " + rs.getInt("sal"));
		}
	}
	
	static void updateEmployee(Employee emp) throws SQLException {
		conn = Utility.createConnection();
		String sql = "update emp set name = ?, sal = ? where id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, emp.getName());
		statement.setInt(2, emp.getSalary());
		statement.setString(3, emp.getId());
		
		statement.executeUpdate();
	}
	
	static void deleteEmployee(String empId) throws SQLException {
		conn = Utility.createConnection();
		String sql = "delete from emp where id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, empId);
		statement.executeUpdate();
	}
}
