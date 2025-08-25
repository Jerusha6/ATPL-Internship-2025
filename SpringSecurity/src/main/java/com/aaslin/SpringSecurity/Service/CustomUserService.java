package com.aaslin.SpringSecurity.Service;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.aaslin.SpringSecurity.dao.UserRepository;
import com.aaslin.SpringSecurity.model.Users;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserService implements UserDetailsService {

    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) 
                .roles(user.getRole())
                .build();
    }
}
