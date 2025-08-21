package com.aaslin.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withUsername("Jerusha")
				.password("{noop}jerusha")
				.roles("USER")
				.build();

		UserDetails admin = User.withUsername("Rani")
				.password("{noop}rani")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(admin,user);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/user/**").hasRole("USER")
				.requestMatchers("/register").permitAll()
				.anyRequest().authenticated()
				)

		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
