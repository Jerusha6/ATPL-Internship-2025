package com.aaslin.SpringSecurity.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.aaslin.SpringSecurity.dao.UserRepository;
import com.aaslin.SpringSecurity.model.Users;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepo.findByUsername("admin").isEmpty()) {
            Users admin = new Users(null, "admin", encoder.encode("jerusha@123"), "ADMIN");
            userRepo.save(admin);
        }
        if (userRepo.findByUsername("user").isEmpty()) {
            Users user = new Users(null, "user", encoder.encode("user@123"), "USER");
            userRepo.save(user);
        }
    }
}
