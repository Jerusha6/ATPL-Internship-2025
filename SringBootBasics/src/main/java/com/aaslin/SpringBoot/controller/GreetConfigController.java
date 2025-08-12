package com.aaslin.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.SpringBoot.service.GreetingService;

@RestController 
public class GreetConfigController {
	
	private GreetingService greetingService;
	
	@Autowired
	public GreetConfigController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	@RequestMapping("/greet")
	public String greetController() {
		return greetingService.greet();
	}
}
