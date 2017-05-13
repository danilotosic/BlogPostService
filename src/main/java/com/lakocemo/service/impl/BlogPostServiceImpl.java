package com.lakocemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lakocemo.model.BlogPost;
import com.lakocemo.repository.BlogPostRepository;
import com.lakocemo.service.BlogPostService;

@Service
public class BlogPostServiceImpl implements BlogPostService {

	private final int SIZE = 10;

	@Autowired
	private BlogPostRepository blogPostRepo;

	@Override
	public BlogPost findByID(Long blogPostID) {
		return blogPostRepo.findOne(blogPostID);
	}

	@Override
	public Page<BlogPost> findAll(int page) {
		return blogPostRepo.findAll(new PageRequest(page, SIZE));
	}

	@Override
	public BlogPost create(BlogPost blogPost) {
		return blogPostRepo.save(blogPost);
	}

	@Override
	public BlogPost update(BlogPost blogPost) {
		return blogPostRepo.save(blogPost);
	}

	@Override
	public BlogPost delete(Long blogPostID) {
		BlogPost retVal = blogPostRepo.findOne(blogPostID);
		blogPostRepo.delete(blogPostID);
		return retVal;
	}

}
