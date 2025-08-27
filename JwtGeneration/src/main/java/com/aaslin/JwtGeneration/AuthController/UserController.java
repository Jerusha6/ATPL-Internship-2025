package com.aaslin.JwtGeneration.AuthController;

import com.aaslin.JwtGeneration.jwt.JwtService;
import com.aaslin.JwtGeneration.model.UserEntity;
import com.aaslin.JwtGeneration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/register")
    public String registerForm(){
        return "redirect:/register.html";
    }

    @GetMapping("/login")
    public String signinForm(){
        return "redirect:/index.html";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute UserEntity user) {
        service.registerUser(user);
        return "redirect:/index.html";
    }

    @PostMapping("/checkCredentials")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
        Optional<UserEntity> userOpt = service.findUserByUsername(username);

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found: " + username);
        }

        if (service.checkCredentials(username, password)) {
            // Generate JWT
            String token = jwtService.generateToken(username);

            return ResponseEntity.ok("JWT Token: " + token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials for user: " + username);
        }
    }

}
