package com.ndtinh.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ndtinh.demo.dto.AuthorDTO;
import com.ndtinh.demo.service.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/author/{id}")
	public ResponseEntity<Object> getAuthorQueryDsl(@PathVariable long id) {
		return ResponseEntity.status(200).body(authorService.getQueryDsl(id));
	}
	
	@GetMapping("/author")
	public ResponseEntity<Object> getAuthorQueryDsl() {
		return ResponseEntity.status(200).body(authorService.getAllQueryDsl());
	}
	
	@PostMapping("/author")
	public ResponseEntity<Object> insertAuthorQueryDsl(@RequestBody AuthorDTO authorDTO) {
		if (authorService.insertQueryDsl(authorDTO)) {
			return ResponseEntity.status(200).body(authorDTO);
		}
		return ResponseEntity.status(400).body("Bad request");
	}
	
	@PutMapping("/author/{id}")
	public ResponseEntity<Object> updateAuthorQueryDsl(@PathVariable long id, @RequestBody AuthorDTO authorDTO) {
		if (authorService.updateQueryDsl(id, authorDTO)) {
			return ResponseEntity.status(200).body(authorDTO);
		}
		return ResponseEntity.status(400).body("Bad request");
	}
	
	@DeleteMapping("/author/{id}")
	public ResponseEntity<Object> deleteAuthorQueryDsl(@PathVariable long id) {
		if (authorService.deleteQueryDsl(id) != null) {
			return ResponseEntity.status(200).body(authorService.deleteQueryDsl(id));
		}
		return ResponseEntity.status(400).body("Bad request");
	}
}
