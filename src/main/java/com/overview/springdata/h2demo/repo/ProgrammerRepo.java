package com.overview.springdata.h2demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overview.springdata.h2demo.domain.Programmer;

public interface ProgrammerRepo extends JpaRepository<Programmer, Long> {

}
