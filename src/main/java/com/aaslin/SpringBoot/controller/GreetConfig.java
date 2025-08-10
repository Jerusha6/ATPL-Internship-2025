package com.aaslin.SpringBoot.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aaslin.SpringBoot.service.GreetingService;

@Configuration 
public class GreetConfig {
	
	@Bean
	public GreetingService greetingService() {
		return new GreetingService();
	}
	
}
