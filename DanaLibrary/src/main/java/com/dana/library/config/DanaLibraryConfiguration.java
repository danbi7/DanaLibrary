package com.dana.library.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan
public class DanaLibraryConfiguration implements WebMvcConfigurer{
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
