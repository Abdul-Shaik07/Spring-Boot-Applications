package com.java.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "abbu123";
		//String table = "create table employee(eid int(4) primary key, ename varchar(20), salary decimal(5,2))";
		String insert = "insert into employee values(1, 'Jones', 344)";
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			Connection connection = DriverManager.getConnection(url,username, password);
			Statement statement = connection.createStatement();
//			boolean execute = statement.execute(table);
			int executeUpdate = statement.executeUpdate(insert);
			
			if(executeUpdate == 1) {
				System.out.println("Values effected at " +executeUpdate);
			} else {
				System.out.println("Values not effected at " +executeUpdate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
