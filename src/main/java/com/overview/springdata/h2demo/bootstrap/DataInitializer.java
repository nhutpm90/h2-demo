package com.overview.springdata.h2demo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.overview.springdata.h2demo.domain.Employee;
import com.overview.springdata.h2demo.repo.EmployeeRepo;


@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	EmployeeRepo employeeRepo;
	

	public DataInitializer() {
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}

