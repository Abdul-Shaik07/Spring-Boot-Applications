package com.java.wipro.ems.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.wipro.ems.pojo.Employee;

public class EmployeeModel {
	int count = 0;
	public int insertAdd(Employee emp) {
		
		
			Connection conn = DBConnection.getDBConnection();
			
			try {
				String insertQuery = "insert into employee values(?,?,?)";
				PreparedStatement statement = conn.prepareStatement(insertQuery);
				statement.setInt(1, emp.getEmpno());
				statement.setString(2, emp.getEmpname());
				statement.setDouble(3, emp.getSal());
				count = statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return count;	
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		
		Connection conn = DBConnection.getDBConnection();
		
		try {
			
			String query = "Select * from employee";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet executeQuery = ps.executeQuery();
			
			while(executeQuery.next()) {
				Employee e = new Employee(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getDouble(3));
				list.add(e);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

}
