package com.overview.springdata.h2demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overview.springdata.h2demo.domain.Cart;

public interface CartRepo extends JpaRepository<Cart, Long> {

	List<Cart> findByName(String name);
}