package com.java.mappings.Repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.mappings.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
