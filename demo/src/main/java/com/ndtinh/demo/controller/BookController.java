package com.ndtinh.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ndtinh.demo.model.BookModel;
import com.ndtinh.demo.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService; 
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	
	/*
	 * Get list book
	 * @Param none
	 * @Return list book
	 * */
	@GetMapping("/book")
	public ResponseEntity<Object> getBook() {
		logger.debug("GET LIST");
		return ResponseEntity.status(200)
				.body(bookService.getListBook());
	}
	
	@PostMapping("/book")
	public ResponseEntity<Object> createBook(@RequestBody BookModel book) {
		logger.debug("Create The Book {}: ", book);
		
		return bookService.createBook(book);
	}
}
