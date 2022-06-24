package com.ndtinh.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ndtinh.demo.controller.BookController;
import com.ndtinh.demo.dto.BookDTO;
import com.ndtinh.demo.entity.Book;
import com.ndtinh.demo.model.BookModel;
import com.ndtinh.demo.repository.BookRepository;
import com.ndtinh.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	/*
	 * Get List Book
	 * */
	@Override
	public List<BookDTO> getListBook() {
		List<BookDTO> listBook = new ArrayList<>();
		bookRepository.findAll().forEach(lb -> {
			listBook.add(modelMapper.map(lb, BookDTO.class));
		});
		return listBook;
	}
	
	/*
	 * Create Book
	 * @Param the book
	 * @Return the book
	 * */
	@Override
	public ResponseEntity<Object> createBook(BookModel bookM) {
		logger.warn("In - book {}", bookM);
		BookDTO bookDTO = new BookDTO();
		Book book = modelMapper.map(bookM, Book.class);
		System.out.println(book.getId());
		System.out.println(book.getName());
		try {
			bookRepository.save(book);
		} catch(IllegalArgumentException e) {
			return ResponseEntity.status(400).body("Not Found");
		}
		bookDTO = modelMapper.map(bookM, BookDTO.class);
		logger.debug("Out - result {}", bookDTO);
		return ResponseEntity.status(200).body(bookDTO);
	}

	
}