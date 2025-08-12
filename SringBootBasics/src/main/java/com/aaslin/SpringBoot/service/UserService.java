package com.aaslin.SpringBoot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.SpringBoot.model.Users;

@Service
public class UserService {
	@Autowired
	Users user;

	List<Users> userList = new ArrayList<>(Arrays.asList(new Users(1,"jerusha",21), new Users(2,"elisha",18), new Users(3, "roja", 34)));

	public List<Users> getUsers() {
		return userList;
	}

	public Users getUser(int userId) {
	    return userList.stream()
	                   .filter(u -> u.getUserId() == userId)
	                   .findFirst()
	                   .orElse(null);
	}

	public void addUser(Users user) {
		userList.add(user);
	}
	
}
