package com.overview.springdata.h2demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import com.overview.springdata.h2demo.domain.Book;
import com.overview.springdata.h2demo.repo.BookRepository;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.overview.springdata.h2demo.bootstrap"})
class SpringBootJpaTestSlice {

	@Autowired
	BookRepository bookRepo;
	
//	@Rollback(value = false)
	@Commit
	@Order(1)
	@Test
	void testJpaTestSlice() {
		long countBefore = this.bookRepo.count();
		assertThat(countBefore).isEqualTo(2);
		
		bookRepo.save(new Book("myBook", "12345", "self"));
		
		long countAfter = this.bookRepo.count();
		
		assertThat(countBefore).isLessThan(countAfter);
	}

	@Order(2)
	@Test
	void testJpaTestSliceTransaction() {
		long countBefore = this.bookRepo.count();
		assertThat(countBefore).isEqualTo(3);
	}
}
