package com.aaslin.SpringBoot.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaslin.SpringBoot.service.GreetByNameService;

@Controller
public class GreetByNameController {
	
	@Autowired
	GreetByNameService greetService;
	
	@GetMapping("/getGreet")
	public String showForm() {
		return "Greet";
	}
	
	@GetMapping("/greeting")
	public String getGreeting(@RequestParam String fname, @RequestParam String lname, Model model) {
		String message = greetService.greet(fname, lname);
		model.addAttribute("greetingMessage", message);
		return "GreetingResult";
	}
	
}
