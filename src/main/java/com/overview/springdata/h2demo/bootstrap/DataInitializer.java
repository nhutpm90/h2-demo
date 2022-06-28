package com.overview.springdata.h2demo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.overview.springdata.h2demo.domain.Cart;
import com.overview.springdata.h2demo.domain.Item;
import com.overview.springdata.h2demo.repo.CartRepo;
import com.overview.springdata.h2demo.repo.ItemRepo;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	ItemRepo itemRepo;

	public DataInitializer() {
	}

	@Override
	public void run(String... args) throws Exception {
		Cart cart = new Cart("C001");
		
		cart.getItems().add(new Item("S001", cart));
		cart.getItems().add(new Item("S002", cart));
		cart.getItems().add(new Item("S003", cart));
		
		cartRepo.save(cart);
	}
}

