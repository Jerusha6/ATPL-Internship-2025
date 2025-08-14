package com.aaslin.CustomValidatorIntegration.dto;

import org.springframework.stereotype.Component;

import com.aaslin.CustomValidatorIntegration.annotation.PasswordMatch;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Component
@PasswordMatch
public class UserRegistration {
	
	@NotNull(message="userName should not be null")
	private String userName;
	
	@NotNull(message="password should not be null")
	private String password;
	
	@NotNull(message="confirm Password should not be null")
	private String confirmPassword;
	
	@NotNull(message="age should not be null")
	@Positive(message="age should be positive")
	@Min(value=18, message="age should be greater than 17")
	private int age;
	
	public UserRegistration() {}
	
	public UserRegistration(String userName, String password, String confirmPassword, int age) {
		super();
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public int getAge() {
		return age;
	}
	
	
}
