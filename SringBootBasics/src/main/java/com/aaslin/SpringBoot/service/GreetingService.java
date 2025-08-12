package com.aaslin.SpringBoot.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	public String greet() {
		return "Hello, Good Morning! from Greeting service";
	}
	
	

}
