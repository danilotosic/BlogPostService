package com.lakocemo.dto;

import java.util.Date;

public class BlogPostDTO {

	private Long blogPostID;
	private String title;
	private String content;
	private Date publishDate;
	private AuthorDetails authorDetails;

	public Long getBlogPostID() {
		return blogPostID;
	}

	public void setBlogPostID(Long blogPostID) {
		this.blogPostID = blogPostID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public AuthorDetails getAuthorDetails() {
		return authorDetails;
	}

	public void setAuthorDetails(AuthorDetails authorDetails) {
		this.authorDetails = authorDetails;
	}

}
