package com.overview.springdata.h2demo;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.overview.springdata.h2demo.domain.Employee;
import com.overview.springdata.h2demo.repo.EmployeeRepo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.overview.springdata.h2demo.bootstrap"})
class SpringBootJpaTestSlice {

	@Autowired
	EmployeeRepo employeeRepo;
	
//	@Rollback(value = false)
//	@Commit
	@Order(1)
	@Test
	void testEmployeeRepo01() {
		System.out.println("------------------start testEmployeeRepo01--------------------");
		
		System.out.println("------------------findByFirstName");
		List<Employee> employeesByFirstName = this.employeeRepo.findByFirstName("Irene");
		System.out.println("findByFirstName:: size:: " + employeesByFirstName.size() + " - data:: " + employeesByFirstName);
		
		System.out.println("------------------findByEmail");
		Employee findByEmail = this.employeeRepo.findByEmail("jbeagles1@bizjournals.com");
		System.out.println("findByEmail:: " + findByEmail);
		
		System.out.println("------------------findByLastNameLike");
		List<Employee> employeesByLastName = this.employeeRepo.findByLastNameLike("%nn%");
		System.out.println("findByLastNameLike:: size:: " + employeesByLastName.size() + " - data:: " + employeesByLastName);
		
		System.out.println("------------------findByIdIn");
		List<Long> employeeIds = Arrays.asList(1L, 2L, 3L);
		List<Employee> employeesByIds = this.employeeRepo.findByIdIn(employeeIds);
		System.out.println("findByIdIn:: size:: " + employeesByIds.size() + " - data:: " + employeesByIds);
		System.out.println("------------------end testEmployeeRepo01--------------------");
	}

	@Order(2)
	@Test
	void testEmployeeRepo02() {
		System.out.println("------------------start testEmployeeRepo01--------------------");
		
		System.out.println("------------------findAll with PageRequest");
		PageRequest pageRequest = PageRequest.of(1, 5);
		Page<Employee> employees = this.employeeRepo.findAll(pageRequest);
		List<Employee> content = employees.getContent();
		System.out.println("findAll with PageRequest:: size:: " + content.size() + " - data:: " + content);
		System.out.println("findAll with PageRequest:: employees:: " + employees);
		
		System.out.println("------------------findAll with Sort");
		Sort sort = Sort.by(Sort.Direction.DESC, "firstName");
		pageRequest = PageRequest.of(2, 5, sort);
		employees = this.employeeRepo.findAll(pageRequest);
		content = employees.getContent();
		System.out.println("findAll with Sort:: size:: " + content.size() + " - data:: " + content);
		System.out.println("findAll with Sort:: employees:: " + employees);
		
		
		System.out.println("------------------findByLastNameLike Paging");
		List<Employee> employeesByLastName = this.employeeRepo.findByLastNameLike("%nn%", 
				PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "firstName")));
		System.out.println("findByLastNameLike Paging:: size:: " + employeesByLastName.size() + " - data:: " + employeesByLastName);
		
		System.out.println("------------------end testEmployeeRepo01--------------------");
	}
}
