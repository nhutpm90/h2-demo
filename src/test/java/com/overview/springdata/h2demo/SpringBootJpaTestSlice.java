package com.overview.springdata.h2demo;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import com.overview.springdata.h2demo.domain.Address;
import com.overview.springdata.h2demo.repo.AddressRepository;
import com.overview.springdata.h2demo.repo.EmployeeRepository;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.overview.springdata.h2demo.bootstrap"})
class SpringBootJpaTestSlice {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	AddressRepository addressRepo;
	
//	@Rollback(value = false)
	@Commit
	@Order(1)
	@Test
	void testJpaTestSlice() {
		
		System.out.println("------------------testJpaTestSlice--------------------");
		
//		List<Employee> employees = employeeRepo.findByFirstName("Nhut");
//		Employee employee = employees.get(0);
//		Address address = employee.getAddress();
//		System.out.println(address.getStreet());
		
		
//		employees.forEach(emp -> {
//			System.out.println(emp.getFirstName());
//		});
//		
		List<Address> addresses = addressRepo.findByCity("HCM");
//		
		addresses.get(0).getEmployee().getFirstName();
//		addresses.forEach(address -> {
//			System.out.println(address.getStreet());
//		});
		

//		System.out.println("data:: " + employee.getFirstName() + " - street:: " + address.getStreet());
	}

//	@Order(2)
//	@Test
//	void testJpaTestSliceTransaction() {
//		long countBefore = this.bookRepo.count();
//		assertThat(countBefore).isEqualTo(3);
//	}
}
