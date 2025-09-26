package com.java.wipro.web;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	
	public DemoServlet() {
    	System.out.println("DemoServlet object created by Tomcat server");
    }
    
    

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() executed");
	}

	/**
	 * @see Servlet#destroy()
	 */
	
	
	public void destroy() {
		System.out.println("destroy() executed");
	}
	

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() executed");
	}

}
