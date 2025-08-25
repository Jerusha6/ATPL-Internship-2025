package com.aaslin.JwtAuthentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/get-message")
    public String getMessage() {
        return "This is a sample API";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user-data")
    public String getUserData() {
        return "User Data";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin-data")
    public String getAdminData() {
        return "Admin Data";
    }
}