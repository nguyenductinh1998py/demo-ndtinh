package com.ndtinh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ndtinh.demo.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	public Author findByName(String name);
}
