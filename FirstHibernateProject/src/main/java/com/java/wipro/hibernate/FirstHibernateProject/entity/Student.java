package com.java.wipro.hibernate.FirstHibernateProject.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Student {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	private String student_name;
	private double student_marks;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int student_id, String student_name, double student_marks) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_marks = student_marks;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public double getStudent_Marks() {
		return student_marks;
	}
	public void setStudent_Marks(double student_marks) {
		this.student_marks = student_marks;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_marks=" + student_marks + "]";
	}
}
