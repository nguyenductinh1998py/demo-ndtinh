package com.ndtinh.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ndtinh.demo.service.AuthorService;

@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AuthorService authorService;

	@Test
	public void testGetAuthorByUsingQueryDsl() throws Exception {
		// Add authorization headers
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setBasicAuth("admin", "12345678");
		// Check response
		this.mvc.perform(get("/author/{id}", 1)
				.headers(httpHeaders))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testGetListAuthorByUsingQueryDsl() throws Exception {
		// Add authorization headers
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setBasicAuth("admin", "12345678");
		// Check response
		this.mvc.perform(get("/author")
				.headers(httpHeaders))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testUpdateAuthorByUsingQueryDsl() throws Exception {
		// Add authorization headers
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setBasicAuth("admin", "12345678");
		// Fake json
		String json = "{\"id\" : 1, \"name\" : \"Hong Miu\"}";	
		// Check response
		this.mvc.perform(put("/author/{id}", 1)
				.headers(httpHeaders)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isBadRequest());
	}

	@Test
	public void testDeleteAuthorByUsingQueryDsl() throws Exception {
		// Add authorization headers
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setBasicAuth("admin", "12345678");
		// Check response
		this.mvc.perform(delete("/author/{id}", 1)
				.headers(httpHeaders))
		.andExpect(status().isBadRequest());
	}
	


}
