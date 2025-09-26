package com.java.mappings.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.mappings.Entity.Department;
import com.java.mappings.Entity.Employee;
import com.java.mappings.Service.DepartmentService;
@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/saveDepartment")
	public Department saveDepartment(@RequestBody Department department) {		
		//List<Employee> employee = department.getEmployee();
		for(Employee emp : department.getEmployee()) {
			emp.setDepartment(department);
		}
//		Department department = new Department();
//		department.setDepartmentName(department.getDepartmentName());
//		department.setEmployee(department.getEmployee());
		return departmentService.saveDepartment(department);
	}
	@PutMapping("/updateDepartment/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable Long id) {
		return departmentService.updateDepartment(department, id);
	}
	
	@GetMapping("/findAllDepartments")
	public List<Department> findAllDepartment() {
		return departmentService.findAllDepartments();
	}
	@GetMapping("/findByDepartmentId/{id}")
	public Optional<Department> findByDepartmentId(@PathVariable long id) {
		return departmentService.findByDepartmentId(id);
	}
//	@GetMapping("/getEmployeeNames")
//	public List<Department> getEmployeeNames(@PathVariable long id) {
//		return departmentService.getEmployeeNames(id);
//	}
}
