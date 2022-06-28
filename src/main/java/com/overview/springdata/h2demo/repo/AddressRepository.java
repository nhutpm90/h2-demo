package com.overview.springdata.h2demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overview.springdata.h2demo.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	
	List<Address> findByCity(String city);
}
