package com.ndtinh.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndtinh.demo.dto.AuthorDTO;
import com.ndtinh.demo.entity.Author;
import com.ndtinh.demo.entity.QAuthor;
import com.ndtinh.demo.service.AuthorService;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AuthorDTO getQueryDsl(long id) {
		// Init query for table Author
		JPAQuery<Author> query = new JPAQuery<>(em);
		// Init Querydsl query type for Author
		QAuthor author = QAuthor.author;
		// Query sql get a author
		Author listAuthor = query.from(author).where(author.id.eq(id)).fetchFirst();
		return modelMapper.map(listAuthor, AuthorDTO.class);
	}

	@Override
	public List<AuthorDTO> getAllQueryDsl() {
		// Init query for table Author
		JPAQuery<Author> query = new JPAQuery<>(em);
		// Init Querydsl query type for Author
		QAuthor author = QAuthor.author;
		// Query sql get list authors
		List<Author> listAuthor = query.from(author).fetch();
		List<AuthorDTO> listAuthorDTO = new ArrayList<>();
		for(Author a : listAuthor) {
			listAuthorDTO.add(modelMapper.map(a, AuthorDTO.class));
		}
		return listAuthorDTO;
	}

	@Override
	@Transactional
	public boolean updateQueryDsl(long id, AuthorDTO authorDTO) {
		// Init query
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		// Init Querydsl query type for Author
		QAuthor qAuthor = QAuthor.author;
		long check = queryFactory.update(qAuthor).where(qAuthor.id.eq(id))
			.set(qAuthor.name, authorDTO.getName())
			.execute();
		if (check > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean deleteQueryDsl(Long id) {
		// Init query
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		// Init Querydsl query type for Author
		QAuthor qAuthor = QAuthor.author;
		// Check success
		long check = queryFactory.delete(qAuthor).where(qAuthor.id.eq(id)).execute();
		if (check > 0) {
			return true;
		}
		return false;
	}

}
