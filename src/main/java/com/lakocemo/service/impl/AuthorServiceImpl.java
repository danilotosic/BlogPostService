package com.lakocemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lakocemo.model.Author;
import com.lakocemo.repository.AuthorRepository;
import com.lakocemo.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	private final int SIZE = 10;

	@Autowired
	private AuthorRepository authorRepo;

	@Override
	public Author findByID(Long authorID) {
		return authorRepo.findOne(authorID);
	}

	@Override
	public Page<Author> findAll(int page) {
		return authorRepo.findAll(new PageRequest(page, SIZE));
	}

	@Override
	public Author create(Author author) {
		return authorRepo.save(author);
	}

	@Override
	public Author update(Author author) {
		return authorRepo.save(author);
	}

	@Override
	public Author delete(Long authorID) {
		Author retVal = authorRepo.findOne(authorID);
		authorRepo.delete(authorID);
		return retVal;
	}

}
