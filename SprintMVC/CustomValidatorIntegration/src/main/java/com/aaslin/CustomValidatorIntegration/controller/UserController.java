package com.aaslin.CustomValidatorIntegration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.CustomValidatorIntegration.dto.UserRegistration;
import com.aaslin.CustomValidatorIntegration.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<UserRegistration> show() {
		return userService.getUsers();
	}	
	
	@PostMapping("/users")
	public void	 addUser(@Valid @RequestBody UserRegistration user) {
		userService.addUser(user);
	}
	
}
