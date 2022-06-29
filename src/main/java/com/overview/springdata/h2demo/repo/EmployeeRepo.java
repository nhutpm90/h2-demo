package com.overview.springdata.h2demo.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.overview.springdata.h2demo.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	List<Employee> findByFirstName(String firstName);
	
	List<Employee> findByLastNameLike(String lastName);
	
	List<Employee> findByLastNameLike(String lastName, Pageable pageable);
	
	Employee findByEmail(String email);
	
	List<Employee> findByIdIn(List<Long> ids);
}
