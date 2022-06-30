package com.overview.springdata.h2demo.bootstrap;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.overview.springdata.h2demo.domain.License;
import com.overview.springdata.h2demo.domain.Person;
import com.overview.springdata.h2demo.repo.LicenseRepo;


@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	LicenseRepo licenseRepo;
	
	public DataInitializer() {
	}

	@Override
	public void run(String... args) throws Exception {
		
		Person person = new Person("Nhut Pham");

		License license = new License("driving", new Date(), new Date());
		license.setPerson(person);
		
		this.licenseRepo.save(license);
	}
}

