package com.java.mappings.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.mappings.Entity.Department;
import com.java.mappings.Entity.Employee;
import com.java.mappings.Repsitory.DepartmentRepository;
import com.java.mappings.Repsitory.EmployeeRepository;
@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public Department updateDepartment(Department department, long id) {
		
		/*Department department2 = departmentRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Id is not found to update"));

		    if (department.getDepartmentName() != null) {
		        department2.setDepartmentName(department.getDepartmentName());
		    }

		    if (department.getEmployee() != null) {
		        List<Employee> updateEmployee = new ArrayList<>();
		        for (Employee emp : department.getEmployee()) {
		            Employee employee2 = employeeRepository.findById(emp.getId())
		                .orElseThrow(() -> new RuntimeException("Employee id is not found to update"));

		            if (emp.getEmployeeName() != null) employee2.setEmployeeName(emp.getEmployeeName());
		            if (emp.getSkills() != null) employee2.setSkills(emp.getSkills());
		            if (emp.getExperience() != 0) employee2.setExperience(emp.getExperience());
		            if (emp.getLocation() != null) employee2.setLocation(emp.getLocation());

		            // Always link to updated department
		            employee2.setDepartment(department2);

		            updateEmployee.add(employee2);
		        }

		        department2.setEmployee(updateEmployee);
		    }

		    return departmentRepository.save(department2);
		
		*/
		
		
		
		
		Optional<Department> department3 = departmentRepository.findById(id);
		Department department2 = null;
		if(department3.isPresent()) {
			 department2 = department3.get();
			if(department.getDepartmentName() != null) {
				department2.setDepartmentName(department.getDepartmentName());
			}
		} else {
			throw new RuntimeException("Id is not found to update");
		}
		
		if(department.getEmployee() != null) {
			List<Employee> updateEmployee = new ArrayList<>();
			for(Employee emp : department.getEmployee()) 
			{
				Optional<Employee> byId = employeeRepository.findById(emp.getId());
				Employee employee2 = null;
				if(byId.isPresent()) {
					 employee2 = byId.get();
					if(emp.getEmployeeName() != null) {
						employee2.setEmployeeName(emp.getEmployeeName());
					}
					if(emp.getSkills() != null) {
						employee2.setSkills(emp.getSkills());
					}
					if(emp.getExperience() != 0) {
						employee2.setExperience(emp.getExperience());
					}
					if(emp.getLocation() != null) {
						employee2.setLocation(emp.getLocation());
					}
					employee2.setDepartment(department2);
					employeeRepository.save(employee2);
					updateEmployee.add(employee2);
				} else {
					throw new RuntimeException("Employee id is not found to update");
				}
			}
			
			department2.setEmployee(updateEmployee);
			
		}
		
		return departmentRepository.save(department2);
	
		

		

//		Employee employee = new Employee();
//		employee.setEmployeeName(employee.getEmployeeName());
//		employee.setExperience(employee.getExperience());
//		employee.setLocation(employee.getLocation());
//		employee.setSkills(employee.getSkills());
//		employeeRepository.save(employee);
//		return departmentRepository.save(department);
	}
	
	public List<Department> findAllDepartments() {
		return departmentRepository.findAll();
	}
	
	public Optional<Department> findByDepartmentId(long id) {
		return departmentRepository.findById(id);
	}

//	public List<Department> getEmployeeNames(long id) {
//		return departmentRepository.getEmployeeNames(id);
//	}
	
}
