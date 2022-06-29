package com.overview.springdata.h2demo;

import java.util.Set;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import com.overview.springdata.h2demo.domain.Customer;
import com.overview.springdata.h2demo.domain.PhoneNumber;
import com.overview.springdata.h2demo.repo.CustomerRepo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.overview.springdata.h2demo.bootstrap"})
class SpringBootJpaTestSlice {

	@Autowired
	CustomerRepo customerRepo;
	
//	@Rollback(value = false)
//	@Commit
	@Order(1)
	@Test
	void testCustomerRepo01() {
		System.out.println("------------------start testCustomerRepo01--------------------");
		
		System.out.println("------------------start testGetById--------------------");
		Customer customer = customerRepo.getById(1L);
		Set<PhoneNumber> phoneNumbers = customer.getPhoneNumbers();
		phoneNumbers.forEach(phoneNumber -> System.out.println(phoneNumber));
		
		System.out.println("------------------start testUpdate--------------------");
		customer.setName("Rango");
		phoneNumbers.forEach(phoneNumber -> {
			phoneNumber.setType("home");
		});
		this.customerRepo.saveAndFlush(customer);
		
		System.out.println("------------------end testCustomerRepo01--------------------");
	}

	@Order(2)
	@Test
	void testCustomerRepo02() {}
	
}
