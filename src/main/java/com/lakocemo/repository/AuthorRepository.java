package com.lakocemo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.lakocemo.model.Author;

@Repository
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

	
	
}
