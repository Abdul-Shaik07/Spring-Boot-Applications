package com.java.mappings.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String employeeName;
	private String skills;
	private double experience;
	private String location;
	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	@JsonIgnore  
	private Department department;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public double getExperience() {
		return experience;
	}
	public void setExperience(double experience) {
		this.experience = experience;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(long id, String employeeName, String skills, double experience, String location, Department department) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.skills = skills;
		this.experience = experience;
		this.location = location;
		this.department = department;
	}
    @Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", skills=" + skills + ", experience="
				+ experience + ", location=" + location + "]";
	}
	
	
}
