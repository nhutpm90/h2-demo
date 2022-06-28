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

import com.overview.springdata.h2demo.domain.User;
import com.overview.springdata.h2demo.domain.UserProfile;
import com.overview.springdata.h2demo.repo.UserProfileRepo;
import com.overview.springdata.h2demo.repo.UserRepo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.overview.springdata.h2demo.bootstrap"})
class SpringBootJpaTestSlice {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserProfileRepo userProfileRepo;
	
//	@Rollback(value = false)
//	@Commit
	@Order(1)
	@Test
	void testUserRepo01() {
		System.out.println("------------------testUserRepo01--------------------");
		List<User> users = userRepo.findByUsername("nhut.pham");
		User user = users.get(0);
		String username = user.getUsername();
		System.out.println("username:: " + username);
		
		System.out.println("------------------testUserRepo01--------------------");
		System.out.println("address::" + user.getUserProfile().getAddress());
	}

	@Order(2)
	@Test
	void testUserProfileRepo01() {
		System.out.println("------------------testUserProfileRepo01--------------------");
		List<UserProfile> userProfiles = userProfileRepo.findByFirstName("Nhut");
		UserProfile up = userProfiles.get(0);
		System.out.println("address:: " + up.getAddress());
		
		System.out.println("------------------testUserProfileRepo01--------------------");
		System.out.println("username:: " + up.getUser().getUsername());
	}
}
