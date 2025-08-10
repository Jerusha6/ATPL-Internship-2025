package com.aaslin.SpringBoot.service;

import org.springframework.stereotype.Service;

@Service
public class GreetByNameService {

	public String greet(String fname, String lname) {
		return "Hello "+fname+" "+lname+"!";
	}	
}
