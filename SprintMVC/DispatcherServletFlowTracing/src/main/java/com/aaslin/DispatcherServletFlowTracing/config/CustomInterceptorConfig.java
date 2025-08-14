package com.aaslin.DispatcherServletFlowTracing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomInterceptorConfig implements WebMvcConfigurer{
	
	@Override 
	public void addInterceptors(InterceptorRegistry register) {
		register.addInterceptor(new CustomeInterceptor());
	}
	
	
}
