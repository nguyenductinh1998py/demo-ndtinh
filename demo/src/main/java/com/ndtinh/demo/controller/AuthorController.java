package com.ndtinh.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ndtinh.demo.dto.AuthorDTO;
import com.ndtinh.demo.service.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	private static final Logger logger = Logger.getLogger(BookController.class);
	
	/**
	 * Get the author
	 * @param Long id
	 * @return The author
	 */
	@GetMapping("/author/{id}")
	public ResponseEntity<Object> getAuthorQueryDsl(@PathVariable long id) {
		logger.debug("GET AUTHOR BY ID: " + id);
		return ResponseEntity.status(200).body(authorService.getQueryDsl(id));
	}
	
	/**
	 * Get list authors
	 * @return List authors
	 */
	@GetMapping("/author")
	public ResponseEntity<Object> getAuthorQueryDsl() {
		logger.debug("GET LIST AUTHOR");
		return ResponseEntity.status(200).body(authorService.getAllQueryDsl());
	}
	
	/**
	 * Update author
	 * @param Long id, AuthorDTO
	 * @return AuthorDTO
	 */
	@PutMapping("/author/{id}")
	public ResponseEntity<Object> updateAuthorQueryDsl(@PathVariable long id, @RequestBody AuthorDTO authorDTO) {
		logger.debug("UPDATE THE AUTHOR BY ID:"+ id + "SET: " + authorDTO.toString());
		if (authorService.updateQueryDsl(id, authorDTO)) {
			return ResponseEntity.status(200).body(authorDTO);
		}
		return ResponseEntity.status(400).body("Bad request");
	}
	
	/**
	 * Delete author 
	 * @param Long id
	 * @return Status
	 */
	@DeleteMapping("/author/{id}")
	public ResponseEntity<Object> deleteAuthorQueryDsl(@PathVariable long id) {
		logger.debug("DELETE THE AUTHOR WITH ID" + id);
		if (authorService.deleteQueryDsl(id)) {
			return ResponseEntity.status(204).body("Ok");
		}
		return ResponseEntity.status(400).body("Bad request");
	}
	
}
