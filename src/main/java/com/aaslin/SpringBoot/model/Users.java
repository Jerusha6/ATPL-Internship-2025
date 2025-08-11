package com.aaslin.SpringBoot.model;

import org.springframework.stereotype.Component;


@Component
public class Users {
	
	private int userId;
	private String userName;;
	private int userAge;
	
	public Users() {}
	
	public Users(int userId, String userName, int userAge) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public int getUserAge() {
		return userAge;
	}
	
}
