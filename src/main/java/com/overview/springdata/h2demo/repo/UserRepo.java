package com.overview.springdata.h2demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overview.springdata.h2demo.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

	List<User> findByUsername(String username);
}
