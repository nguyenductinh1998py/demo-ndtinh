package com.ndtinh.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ndtinh.demo.dto.BookDTO;
import com.ndtinh.demo.entity.Author;
import com.ndtinh.demo.entity.Book;
import com.ndtinh.demo.model.BookModel;
import com.ndtinh.demo.repository.AuthorRepository;
import com.ndtinh.demo.repository.BookRepository;
import com.ndtinh.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final Logger logger = Logger.getLogger(BookServiceImpl.class);
	
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
		logger.warn("In - book " + bookM);
		BookDTO bookDTO = new BookDTO();
		Author author = authorRepository.findByName(bookM.getAuthorName());
		if (author == null) {
			return ResponseEntity.status(400).body("Bad Request");
		}
		Book book = modelMapper.map(bookM, Book.class);
		book.setAuthor(author);
		try {
			bookDTO = modelMapper.map(bookRepository.save(book), BookDTO.class);
		} catch(IllegalArgumentException e) {
			
		}
		logger.debug("Out - result " + bookDTO);
		return ResponseEntity.status(200).body(bookDTO);
	}

	
}