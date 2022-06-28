package com.overview.springdata.h2demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overview.springdata.h2demo.domain.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {

	List<Item> findBySerialNumber(String serialNumber);
}
