package com.java.assignments;

import java.sql.Connection;

public class TestSingletonDatabaseConnection {

	public static void main(String[] args) {
		
		SingletonDatabaseConnection sdc = SingletonDatabaseConnection.getInstance();
	
            System.out.println("Connected to SQLite database successfully!");
            System.out.println("COnnection Object : " +connection);  

	}

}
