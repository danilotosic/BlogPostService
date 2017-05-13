package com.lakocemo.service;

import org.springframework.data.domain.Page;

import com.lakocemo.model.Comment;

public interface CommentService {
	
	public Comment findByID(Long commentID);
	public Page<Comment> findAll(int page);
	public Comment create(Comment comment);
	public Comment update(Comment comment);
	public Comment delete(Long commentID);

}
