package com.overview.springdata.h2demo;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import com.overview.springdata.h2demo.domain.License;
import com.overview.springdata.h2demo.repo.LicenseRepo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.overview.springdata.h2demo.bootstrap"})
class SpringBootJpaTestSlice {

	@Autowired
	LicenseRepo licenseRepo;
	
//	@Rollback(value = false)
//	@Commit
	@Order(1)
	@Test
	void testLicenseRepo01() {
		System.out.println("------------------start testLicenseRepo01--------------------");
		
		License license = this.licenseRepo.getById(1L);
		System.out.println(license);
		
		System.out.println("------------------end testLicenseRepo01--------------------");
	}

	@Order(2)
	@Test
	void testLicenseRepo02() {}
	
}
