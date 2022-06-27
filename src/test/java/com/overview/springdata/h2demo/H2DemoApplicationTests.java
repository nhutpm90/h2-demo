package com.overview.springdata.h2demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.overview.springdata.h2demo.repo.BookRepository;

@SpringBootTest
class H2DemoApplicationTests {

	@Autowired
	BookRepository bookRepo;

	@Test
	void testBookRepository() {
		long count = this.bookRepo.count();
		assertThat(count).isGreaterThan(0);
	}

	@Test
	void contextLoads() {
	}

}
