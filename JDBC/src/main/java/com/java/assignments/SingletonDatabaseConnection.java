package com.java.assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class SingletonDatabaseConnection {
	
	private static volatile SingletonDatabaseConnection instance;
	
	private Connection connection;
	
	private SingletonDatabaseConnection() {
	
		System.out.println("Connecting to database ");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public static SingletonDatabaseConnection getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
