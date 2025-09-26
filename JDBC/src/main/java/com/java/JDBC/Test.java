package com.java.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "abbu123";
		String table = "create table Test(id int primary key, name varchar(20))";
		String insert = "insert into test values(1, 'Java')";
		try {
			System.out.println("hello1");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("hello1");
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			System.out.println("hello1");
			boolean execute = statement.execute(table);
			System.out.println("hello1");
			if(execute) {
				System.out.println("Created " +execute);
			} else {
				System.out.println("Not Created " +execute);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
