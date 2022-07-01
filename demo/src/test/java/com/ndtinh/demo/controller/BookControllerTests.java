package com.ndtinh.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.ndtinh.demo.service.BookService;

@WebMvcTest(BookController.class)
public class BookControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private BookService bookService;

	@Test
	public void testGetBook() throws Exception {
		// Add authorization headers
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setBasicAuth("admin", "12345678");
		// Check response
		this.mvc.perform(get("/book")
				.headers(httpHeaders))
		.andExpect(status().isOk());
	}

	@Test
	public void testPostBook() throws Exception {
		// Add authorization headers
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setBasicAuth("admin", "12345678");
		// Fake json
		String json = "{\"id\" : 8, \"name\" : \"The Book 8\", \"price\" : 123.1, \"author\" : \"Con khi\"}";
		// Check response
		this.mvc.perform(post("/book")
				.headers(httpHeaders)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testGetBookByUsingQueryDsl() throws Exception {
		// Add authorization headers
		HttpHeaders httpHears = new HttpHeaders();
		httpHears.setBasicAuth("admin", "12345678");
		// Check response
		this.mvc.perform(get("/book/")
				.headers(httpHears))
		.andExpect(status().isOk());
	}

}
