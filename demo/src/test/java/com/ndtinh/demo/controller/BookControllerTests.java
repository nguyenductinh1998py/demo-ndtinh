package com.ndtinh.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookControllerTests {
	@Test
	public void getBookTest() 
			throws ClientProtocolException, IOException {
		// Set authorization header for request
		RequestSpecification httpRequest = 
				RestAssured.given().auth().preemptive().basic("admin", "12345678");
		// Send get method
	    Response res = httpRequest.get("http://localhost:8888/book");
	    // Check the status of the response method
		assertEquals(
				res.getStatusCode(),
			    HttpStatus.SC_OK);
	}
	
	@Test
	public void postBookTest() throws ClientProtocolException, IOException {
		// Set authorization header for request
		RequestSpecification httpRequest = 
				RestAssured.given().auth().preemptive().basic("admin", "12345678");
		// Fake Json body
		String json = "{\"id\" : 8, \"name\" : \"The Book 8\", \"price\" : 123.1, \"author\" : \"Con khi\"}";
		// Set post method with ContendType as JsonObject and body as fake Json
		httpRequest.contentType("application/json").body(json);
		// Send post method
	    Response res = httpRequest.post("http://localhost:8888/book");
	    // Check the status of the response method
	    assertEquals(
				res.getStatusCode(),
			    HttpStatus.SC_OK);
	}
	
}
