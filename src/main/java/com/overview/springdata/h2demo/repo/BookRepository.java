package com.overview.springdata.h2demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overview.springdata.h2demo.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
