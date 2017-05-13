package com.lakocemo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.lakocemo.BlogPostServiceApplication;

@Configuration
@Import({BlogPostServiceApplication.class})
public class BlogPostServiceConfig {

	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
	
}
