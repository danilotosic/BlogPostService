package com.lakocemo.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lakocemo.dto.AuthorDetails;
import com.lakocemo.model.Author;
import com.lakocemo.service.AuthorService;

@Component
public class AuthorConverter {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private AuthorService authorService;

	/**
	 * 
	 * @param author
	 * @return AuthorDetails
	 */
	public AuthorDetails convertToDetails(Author author) {
		if (author == null) {
			return null;
		}
		AuthorDetails authorDetails = mapper.map(author, AuthorDetails.class);
		return authorDetails;
	}

	/**
	 * 
	 * @param authors
	 * @return List of AuthorDetails
	 */
	public List<AuthorDetails> convertToDetails(List<Author> authors) {
		List<AuthorDetails> authorsDetails = new ArrayList<>();
		for (Author a : authors) {
			authorsDetails.add(convertToDetails(a));
		}
		return authorsDetails;
	}

	public Author convertToEntity(AuthorDetails authorDetails) {

		if (authorDetails == null) {
			return null;
		}

		Author author = mapper.map(authorDetails, Author.class);

		return author;
	}

	public List<Author> convertToEntity(List<AuthorDetails> authorsDetails) {
		List<Author> authors = new ArrayList<>();
		
		for (AuthorDetails ad : authorsDetails) {
			authors.add(convertToEntity(ad));
		}

		return authors;
	}

}
