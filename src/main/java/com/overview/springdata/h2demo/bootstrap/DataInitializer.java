package com.overview.springdata.h2demo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.overview.springdata.h2demo.domain.Address;
import com.overview.springdata.h2demo.domain.Employee;
import com.overview.springdata.h2demo.repo.EmployeeRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepo;

	public DataInitializer() {
	}

	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee();
		emp.setFirstName("Nhut");
		emp.setLastName("Pham");
		emp.setAge(32);
		Address address = new Address();
		address.setStreet("TVQ");
		address.setAddressType("home");
		address.setCity("HCM");
		emp.setAddress(address);
		employeeRepo.save(emp);
	}
}
