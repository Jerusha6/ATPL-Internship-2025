//package com.aaslin.EmployeeManagementSystemUsingSpringBoot.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//        // Admin user
//        manager.createUser(User.withUsername("admin")
//                .password(encoder.encode("adminpass"))
//                .roles("ADMIN")
//                .build());
//
//        // HR user
//        manager.createUser(User.withUsername("hr")
//                .password(encoder.encode("hrpass"))
//                .roles("HR")
//                .build());
//
//        // Normal employee
//        manager.createUser(User.withUsername("employee")
//                .password(encoder.encode("emppass"))
//                .roles("EMPLOYEE")
//                .build());
//
//        return manager;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/employee/admin/**").hasAnyRole("ADMIN", "HR") // only HR & Admin
//                .requestMatchers("/employee/user/**").hasRole("EMPLOYEE")       // only Employee
//                .anyRequest().authenticated()                                   // all others require login
//            )
//            .formLogin(form -> form
//                .loginPage("/SignIn.html")      // custom login page
//                .loginProcessingUrl("/login")   // form POST URL
//                .defaultSuccessUrl("/default", true) // redirect based on role
//                .permitAll()
//            )
//            .logout(logout -> logout
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/SignIn.html?logout=true")
//            );
//
//        return http.build();
//    }
//}
