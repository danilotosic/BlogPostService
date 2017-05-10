package com.lakocemo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.lakocemo.model.BlogPost;

@Repository
public interface BlogPostRepository extends PagingAndSortingRepository<BlogPost, Long> {
	
	

}
