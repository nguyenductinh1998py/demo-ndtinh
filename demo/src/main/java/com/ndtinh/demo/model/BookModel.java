package com.ndtinh.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {
	private long id;
	private String name;
	private double price;
	@JsonProperty("author")
	private String authorName;
}