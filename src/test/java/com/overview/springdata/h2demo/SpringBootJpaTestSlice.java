package com.overview.springdata.h2demo;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import com.overview.springdata.h2demo.domain.Cart;
import com.overview.springdata.h2demo.domain.Item;
import com.overview.springdata.h2demo.repo.CartRepo;
import com.overview.springdata.h2demo.repo.ItemRepo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.overview.springdata.h2demo.bootstrap"})
class SpringBootJpaTestSlice {

	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	ItemRepo itemRepo;
	
//	@Rollback(value = false)
//	@Commit
	@Order(1)
	@Test
	void testCartRepo01() {
		System.out.println("------------------start testCartRepo01--------------------");
		List<Cart> carts = this.cartRepo.findByName("C001");
		Cart cart = carts.get(0);
		System.out.println("cart:: name:: " + cart.getName());
		
		List<Item> items = cart.getItems();
		items.forEach(item -> {
			System.out.println(cart.getName() + " --> " + item.getSerialNumber());
		});
		System.out.println("------------------end testCartRepo01--------------------");
	}

	@Order(2)
	@Test
	void testItemRepo01() {
		System.out.println("------------------start testItemRepo01--------------------");
		List<Item> items = this.itemRepo.findBySerialNumber("S003");
		Item item = items.get(0);
		System.out.println("item:: serialNumber" + item.getSerialNumber());
		
		Cart cart = item.getCart();
		System.out.println("cart:: name:: " + cart.getName());
		System.out.println("------------------end testItemRepo01--------------------");
	}
}
