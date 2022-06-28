package com.overview.springdata.h2demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overview.springdata.h2demo.domain.UserProfile;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {

	List<UserProfile> findByFirstName(String firstName);
}
