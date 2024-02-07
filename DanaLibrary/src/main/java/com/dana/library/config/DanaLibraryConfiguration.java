package com.dana.library.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import com.dana.library.interceptor.Interceptor;

@Configuration
@ComponentScan
public class DanaLibraryConfiguration implements WebMvcConfigurer {

//	@Autowired
//	Interceptor interceptor;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(interceptor).addPathPatterns("/board/**", "/view/**", "/book/**", "/rent/**", "/reserve/**").excludePathPatterns("/public/**");
//	}
}
