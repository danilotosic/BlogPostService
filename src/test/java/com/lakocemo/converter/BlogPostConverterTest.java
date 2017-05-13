package com.lakocemo.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lakocemo.dto.BlogPostDTO;
import com.lakocemo.model.BlogPost;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogPostConverterTest {
	
	@Autowired
	private BlogPostConverter converter;
	

	@Test
	public void test() {
		BlogPost blogPost = new BlogPost();
		blogPost.setTitle("title");
		
		BlogPostDTO dto = converter.convertToDTO(blogPost);
		
		assertEquals("title", dto.getTitle());
	}

}
