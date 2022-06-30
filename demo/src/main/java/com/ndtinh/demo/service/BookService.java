package com.ndtinh.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ndtinh.demo.dto.BookDTO;
import com.ndtinh.demo.model.BookModel;

public interface BookService {
	public List<BookDTO> getListBook();
	public List<BookDTO> findBookByNameQueryDSL(String name);
	public ResponseEntity<Object> createBook(BookModel book);
}
