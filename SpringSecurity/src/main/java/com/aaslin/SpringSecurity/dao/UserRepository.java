package com.aaslin.SpringSecurity.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aaslin.SpringSecurity.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	Optional<Users> findByUsername(String username);

}
