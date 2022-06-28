package com.overview.springdata.h2demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overview.springdata.h2demo.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findByFirstName(String firstName);
}
