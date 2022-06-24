package com.ndtinh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ndtinh.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
