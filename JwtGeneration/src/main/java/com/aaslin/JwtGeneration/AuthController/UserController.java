package com.aaslin.JwtGeneration.AuthController;

import com.aaslin.JwtGeneration.model.UserEntity;
import com.aaslin.JwtGeneration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private UserService service;
    @GetMapping("/register")
    public String registerForm(){
        return "redirect:/register.html";
    }

    @GetMapping("/login")
    public String signinForm(){
        return "redirect:/index.html";
    }

    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@ModelAttribute UserEntity user) {
        service.registerUser(user);
        return ResponseEntity.ok("User Registered: " + user.getUsername());
    }

//    @GetMapping("/checkCredentials")
//    public ResponseEntity<String> loginUser() {
//
//    }

}
