package com.overview.springdata.h2demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overview.springdata.h2demo.domain.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
