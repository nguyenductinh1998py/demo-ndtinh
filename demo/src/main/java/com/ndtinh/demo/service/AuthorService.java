package com.ndtinh.demo.service;

import java.util.List;

import com.ndtinh.demo.dto.AuthorDTO;

public interface AuthorService {
	public AuthorDTO getQueryDsl(long id);
	public List<AuthorDTO> getAllQueryDsl();
	public boolean updateQueryDsl(long id ,AuthorDTO authorDTO);
	public boolean deleteQueryDsl(Long id);
}
