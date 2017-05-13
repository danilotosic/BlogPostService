package com.lakocemo.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lakocemo.dto.BlogPostDTO;
import com.lakocemo.model.BlogPost;

@Component
public class BlogPostConverter {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private AuthorConverter authorConverter;

	/**
	 * 
	 * @param blogPost
	 * @return blogPostDTO
	 */
	public BlogPostDTO convertToDTO(BlogPost blogPost) {
		if (blogPost == null) {
			return null;
		}
		BlogPostDTO blogPostDTO = mapper.map(blogPost, BlogPostDTO.class);
		blogPostDTO.setAuthorDetails(authorConverter.convertToDetails(blogPost.getAuthor()));
		return blogPostDTO;
	}

	/**
	 * 
	 * @param blogPosts
	 * @return List of blogPostDTO
	 */
	public List<BlogPostDTO> convertToDTO(List<BlogPost> blogPosts) {
		List<BlogPostDTO> dtos = new ArrayList<>();
		for (BlogPost bp : blogPosts) {
			dtos.add(convertToDTO(bp));
		}
		return dtos;
	}

	public BlogPost convertToEntity(BlogPostDTO blogPostDTO) {

		if (blogPostDTO == null) {
			return null;
		}

		BlogPost blogPost = mapper.map(blogPostDTO, BlogPost.class);
		blogPost.setAuthor(authorConverter.convertToEntity(blogPostDTO.getAuthorDetails()));
		blogPost.getAuthor().addBlogPost(blogPost);

		return blogPost;
	}

	public List<BlogPost> convertToEntity(List<BlogPostDTO> blogPostDTOs) {
		List<BlogPost> blogPosts = new ArrayList<>();
		for (BlogPostDTO dto : blogPostDTOs) {
			blogPosts.add(convertToEntity(dto));
		}
		return blogPosts;
	}

}
