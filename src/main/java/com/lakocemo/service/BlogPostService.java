package com.lakocemo.service;

import org.springframework.data.domain.Page;

import com.lakocemo.model.BlogPost;

public interface BlogPostService {
	
	public BlogPost findByID(Long blogPostID);
	public Page<BlogPost> findAll(int page);
	public BlogPost create(BlogPost blogPost);
	public BlogPost update(BlogPost blogPost);
	public BlogPost delete(Long blogPostID);

}
