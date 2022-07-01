package com.ndtinh.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ndtinh.demo.model.BookModel;
import com.ndtinh.demo.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService; 
	
	private static final Logger logger = Logger.getLogger(BookController.class);
	
	
	/**
	 * Get list books
	 * @Param none
	 * @Return list book
	 * */
	@GetMapping("/book")
	public ResponseEntity<Object> getBook() {
		logger.debug("GET LIST");
		return ResponseEntity.status(200)
				.body(bookService.getListBook());
	}
	
	/**
	 * Post the book
	 * @Param The book
	 * @Return The book
	 * */
	@PostMapping("/book")
	public ResponseEntity<Object> createBook(@RequestBody BookModel book) {
		logger.debug("CREATE THE BOOK " + book);
		
		return bookService.createBook(book);
	}
	
	/**
	 * Get the book
	 * @Param The book
	 * @Return The book
	 * */
	@GetMapping("/book/query-dsl/{name}")
	public ResponseEntity<Object> getBookQueryDSL(@PathVariable String name) {
		logger.debug("GET THE BOOK BY NAME" + name);
		return ResponseEntity.status(200)
				.body(bookService.findBookByNameQueryDSL(name));
	}
}
