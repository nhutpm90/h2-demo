package com.overview.springdata.h2demo;

import java.util.Set;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import com.overview.springdata.h2demo.domain.Programmer;
import com.overview.springdata.h2demo.domain.Project;
import com.overview.springdata.h2demo.repo.ProgrammerRepo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.overview.springdata.h2demo.bootstrap"})
class SpringBootJpaTestSlice {

	@Autowired
	ProgrammerRepo programmerRepo;
	
//	@Rollback(value = false)
//	@Commit
	@Order(1)
	@Test
	void testProgrammerRepo01() {
		System.out.println("------------------start testProgrammerRepo01--------------------");
		
		Programmer programmer = programmerRepo.getById(1L);
		System.out.println(programmer);
		
		Set<Project> projects = programmer.getProjects();
		projects.forEach(project -> System.out.println(project));
		
		System.out.println("------------------end testProgrammerRepo01--------------------");
	}

	@Order(2)
	@Test
	void testCustomerRepo02() {}
	
}
