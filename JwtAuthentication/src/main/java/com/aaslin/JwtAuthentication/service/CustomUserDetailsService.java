package com.aaslin.JwtAuthentication.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        if ("user".equals(username)) {
            return new User("user", "{noop}password", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
