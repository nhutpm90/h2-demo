package com.overview.springdata.h2demo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.overview.springdata.h2demo.domain.Programmer;
import com.overview.springdata.h2demo.domain.Project;
import com.overview.springdata.h2demo.repo.ProgrammerRepo;


@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	ProgrammerRepo programmerRepo;
	

	public DataInitializer() {
	}

	@Override
	public void run(String... args) throws Exception {
		
		Programmer programmer = new Programmer("Nhut Pham", 1000L);
		programmer.addProject(new Project("Java"));
		programmer.addProject(new Project("Hibernate"));

		this.programmerRepo.save(programmer);
	}
}

