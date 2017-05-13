package com.lakocemo.service;

import org.springframework.data.domain.Page;

import com.lakocemo.model.Author;

public interface AuthorService {
	
	public Author findByID(Long authorID);
	public Page<Author> findAll(int page);
	public Author create(Author author);
	public Author update(Author author);
	public Author delete(Long authorID);

}
