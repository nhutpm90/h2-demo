package com.overview.springdata.h2demo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.overview.springdata.h2demo.domain.Customer;
import com.overview.springdata.h2demo.domain.PhoneNumber;
import com.overview.springdata.h2demo.repo.CustomerRepo;


@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	CustomerRepo customerRepo;
	

	public DataInitializer() {
	}

	@Override
	public void run(String... args) throws Exception {
		
		Customer customer = new Customer();
		customer.setName("Nhut Pham");
		customer.addPhoneNumber(new PhoneNumber("0123456789", "home"));
		customer.addPhoneNumber(new PhoneNumber("01111111111", "working"));
		
		this.customerRepo.save(customer);
	}
}

