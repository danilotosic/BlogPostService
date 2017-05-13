package com.lakocemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lakocemo.model.Comment;
import com.lakocemo.repository.CommentRepository;
import com.lakocemo.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	private final int SIZE = 10;

	@Autowired
	private CommentRepository commentRepo;

	@Override
	public Comment findByID(Long commentID) {
		return commentRepo.findOne(commentID);
	}

	@Override
	public Page<Comment> findAll(int page) {
		return commentRepo.findAll(new PageRequest(page, SIZE));
	}

	@Override
	public Comment create(Comment comment) {
		return commentRepo.save(comment);
	}

	@Override
	public Comment update(Comment comment) {
		return commentRepo.save(comment);
	}

	@Override
	public Comment delete(Long commentID) {
		Comment retVal = commentRepo.findOne(commentID);
		commentRepo.delete(commentID);
		return retVal;
	}

}
