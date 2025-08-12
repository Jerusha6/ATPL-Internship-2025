package com.aaslin.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.SpringBoot.service.WelcomeService;


@RestController
public class WelcomeController {
	
	@Autowired
	WelcomeService welcomeService;	
	
	@GetMapping("/message")
	public String showMsg() {
		return welcomeService.showMsg();
	}
}
