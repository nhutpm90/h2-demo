package com.overview.springdata.h2demo.bootstrap;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.overview.springdata.h2demo.domain.User;
import com.overview.springdata.h2demo.domain.UserProfile;
import com.overview.springdata.h2demo.repo.UserProfileRepo;
import com.overview.springdata.h2demo.repo.UserRepo;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserProfileRepo userProfileRepo;

	public DataInitializer() {
	}

	@Override
	public void run(String... args) throws Exception {
		UserProfile userProfile = new UserProfile("Nhut", "Pham", "TVQ");
		User user = new User("nhut.pham", "nhut.pham@gmail.com", "123456789", userProfile);
		userProfile.setUser(user);
		userRepo.save(user);
	}
}

