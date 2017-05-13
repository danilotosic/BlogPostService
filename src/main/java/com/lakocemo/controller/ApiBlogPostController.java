package com.lakocemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lakocemo.converter.BlogPostConverter;
import com.lakocemo.dto.BlogPostDTO;
import com.lakocemo.model.BlogPost;
import com.lakocemo.service.BlogPostService;

@RestController
@RequestMapping(value = "/api/blogposts")
public class ApiBlogPostController {

	@Autowired
	private BlogPostService blogPostService;

	@Autowired
	private BlogPostConverter blogPostConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BlogPostDTO>> get(@RequestParam(defaultValue = "0") int page) {
		Page<BlogPost> blogPosts = blogPostService.findAll(page);
		List<BlogPost> retVal = blogPosts.getContent();

		if (retVal.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalpages", blogPosts.getTotalPages() + "");

		return new ResponseEntity<>(blogPostConverter.convertToDTO(retVal), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{blogPostID}", method = RequestMethod.GET)
	public ResponseEntity<BlogPostDTO> get(@PathVariable Long blogPostID) {
		if (blogPostID == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		BlogPost blogPost = blogPostService.findByID(blogPostID);

		if (blogPost == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(blogPostConverter.convertToDTO(blogPost), HttpStatus.OK);
	}
	
	

}
