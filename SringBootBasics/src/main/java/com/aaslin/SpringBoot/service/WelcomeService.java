package com.aaslin.SpringBoot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class WelcomeService {
	
	@Value("${app.message}")
	private String message;
	
	public String showMsg() {
		return message;
	}
}
