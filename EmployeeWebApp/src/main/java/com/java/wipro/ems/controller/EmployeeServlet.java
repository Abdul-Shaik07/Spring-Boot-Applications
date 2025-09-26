package com.java.wipro.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.wipro.ems.model.EmployeeModel;
import com.java.wipro.ems.pojo.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       EmployeeModel em = new EmployeeModel();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.write("<h1 style = 'color: green'>Welcome to servlets class</h1>");
		String empno = request.getParameter("empno");
		String empname = request.getParameter("empname");
		String sal = request.getParameter("sal");
		out.write(empno + " " + empname + " " + sal);
		
		int id = Integer.parseInt(empno);
		double salary = Double.parseDouble(sal);
	
		Employee emp = new Employee(id, empname, salary);
		
		out.write("<h1>Displaying Employee Servlet redirected...</h1>");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/display.jsp");
		
		requestDispatcher.forward(request, response);
		
		
		
		
		
		
		
		//			int count = em.inserAdd(emp);
//		 
//		     if(count > 0) {
//		    	 
//		    	 out.print("<h2 style='color:green'>Employee Registration Successful...</h2>");
//		    	 
//		     }
//		     else {
//		    	 
//		    	 out.print("<h2 style='color:red'>Employee Registration Failed...</h2>");
//		    	 
//		     }
		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
