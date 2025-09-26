package com.java.wipro.ems.pojo;

public class Employee {
	
	private int empno;
	private String empname;
	private double sal;
	
	public Employee(int empno, String empname, double sal) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.sal = sal;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", empname=" + empname + ", sal=" + sal + "]";
	}
	
	
	

}
