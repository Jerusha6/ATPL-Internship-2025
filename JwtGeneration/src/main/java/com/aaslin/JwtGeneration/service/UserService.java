package com.aaslin.JwtGeneration.service;

import com.aaslin.JwtGeneration.model.LoginRequest;
import com.aaslin.JwtGeneration.model.UserEntity;
import com.aaslin.JwtGeneration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;
    public void registerUser(UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getDesignation())
                .build();
    }

    public boolean checkCredentials(LoginRequest request) {
       UserEntity userEntity = userRepository.findByUsername(request.getUsername())
               .orElseThrow(() -> new RuntimeException("User not found"));

       if(passwordEncoder.encode(request.getPassword()).equals(userEntity.getPassword())){
           return true;
       }
       else return false;

    }
}
