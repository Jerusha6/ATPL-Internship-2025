package com.aaslin.SpringSecurity.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aaslin.SpringSecurity.model.Users;
import com.aaslin.SpringSecurity.repository.UserRepository;


@Service
public class UserService implements UserDetailsService{
	

	private final UserRepository userRepo;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepo.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("User not found"));

		return User.withUsername(user.getUsername())
//				.password("{noop}"+user.getPassword())
				.password(user.getPassword())
				.roles(user.getRole().toUpperCase())
				.build();
	}

	public void register(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(user.getRole().toUpperCase());
		userRepo.save(user);
	}
}
