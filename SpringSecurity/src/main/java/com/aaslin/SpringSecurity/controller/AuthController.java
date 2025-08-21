package com.aaslin.SpringSecurity.controller;

import com.aaslin.SpringSecurity.Service.UserService;
import com.aaslin.SpringSecurity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	@Autowired
	UserService service;
	@GetMapping("/hello")
	public String hello(Authentication auth) {
		if(auth!=null) {
			return "Hello "+auth.getName()+"!";
		}
		return "Hello!";
	}
	
	@GetMapping("/admin/dashboard")
	public String adminDashboard(Authentication auth) {
		return "Hello "+ auth.getName()+"!, Here is your admin data:";
	}
	
	@GetMapping("/user/dashboard")
	public String userDashboard(Authentication auth) {
		return "Hello "+ auth.getName()+"!, Here is your data:";
	}

	@PostMapping("/register")
	public String register(@RequestBody Users user){
		service.register(user);
		return "registered";
	}

}
