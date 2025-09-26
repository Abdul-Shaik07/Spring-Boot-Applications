package com.java.assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username= "root";
		String password = "abbu123";
		
		try {
			
			Connection connection = DriverManager.getConnection(url,username,password);
			if (connection != null) {
                System.out.println("Connected to SQLite database successfully!");
                System.out.println("COnnection Object : " +connection);
			}    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
