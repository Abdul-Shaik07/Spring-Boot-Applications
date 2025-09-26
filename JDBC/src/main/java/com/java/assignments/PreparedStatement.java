package com.java.assignments;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class PreparedStatement {
	
	

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username= "root";
		String password = "abbu123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url, username, password);
			String query = "select eid, ename, sal from employee where eid = ?";
			java.sql.PreparedStatement pstmt = 	connection.prepareStatement(query);
			pstmt.setInt(1, 1);
			
			
			ResultSet executeQuery = pstmt.executeQuery();
			
			
			while(executeQuery.next()) {
				System.out.println(+executeQuery.getInt(1) + "  " +executeQuery.getString(2)+  " " +executeQuery.getDouble(3));
			}	
			} catch(Exception e) {
				e.getMessage();
			}
		}
			
			
			
			
			
			
			
			
			
			
			
			//String selectQuery = "select eid, ename, sal from employee where eid = ?";
//			PreparedStatement statement = connection.prepareStatement(selectQuery);
//			statement.setInt(1, 2);
//			ResultSet executeQuery = statement.executeQuery();
//			
//			while(executeQuery.next()) {
//				System.out.println("eid" +executeQuery.getInt(1) + "ename" +executeQuery.getString(2) + "sal" +executeQuery.getDouble(3));
//			}	
//			} catch(Exception e) {
//				e.getMessage();
//			}
			


	}


