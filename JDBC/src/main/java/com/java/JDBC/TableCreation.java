package com.java.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import com.java.JDBC.Insert;
public class TableCreation {
	public static void main(String[] args) {
//		Table table = new Table();
//		table.tableCreate();
		Insert insert = new Insert();
		insert.insert();
		
	}

}

class Table {
	public void tableCreate() {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "abbu123";
		String query = "create table A(id int primary key, name varchar(20))";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			boolean executeUpdate = statement.execute(query);
			System.out.println(executeUpdate);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
	
	
class Insert {
	public void insert() {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "abbu123";
String insert1 = "insert into A values(1,'Abdul')";
//		String insert2 = "insert into A values(2,'Abbu')";
//		String insert3 = "insert into A values(3,'Shaik')";
		String delete = "delete from A where id = 1";
		try { 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();
		statement.executeUpdate(insert1);
//		statement.executeUpdate(insert2);
//		statement.executeUpdate(insert3);
		//statement.executeUpdate(delete);
		System.out.println("Deleted");
		//System.out.println("Inserted into table");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
