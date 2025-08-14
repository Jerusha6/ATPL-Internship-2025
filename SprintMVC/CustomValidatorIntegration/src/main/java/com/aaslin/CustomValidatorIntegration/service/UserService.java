package com.aaslin.CustomValidatorIntegration.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.CustomValidatorIntegration.dto.UserRegistration;



@Service
public class UserService {
	@Autowired
	UserRegistration userRegistration;

	List<UserRegistration> userList = new ArrayList<>(Arrays.asList(new UserRegistration("Jerusha6", "jerusha", "jerusha", 21)));

	public List<UserRegistration> getUsers() {
		return userList;
	}	

	public void addUser(UserRegistration user) {
		userList.add(user);
	}
	
}
