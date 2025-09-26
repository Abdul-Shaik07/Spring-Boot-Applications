package com.java.mappings.Repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.mappings.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
//	@Query(name = "Select e from Employee e, Department d where d.id = e.department_id and d.id = :id")
//	List<Department> getEmployeeNames(@Param(value = "id") long id);

}
