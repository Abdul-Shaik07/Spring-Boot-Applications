package com.java.wipro.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.wipro.ems.model.EmployeeModel;
import com.java.wipro.ems.pojo.Employee;

/**
 * Servlet implementation class DisplayEmployeesServlet
 */
@WebServlet("/DisplayEmployeesServlet")
public class DisplayEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeModel model = new EmployeeModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayEmployeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		List<Employee> allEmployees = model.getAllEmployees();
		
		out.write("List of Employeess");
		
		allEmployees.forEach((emp) -> {out.print(emp + "<br>");});
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
