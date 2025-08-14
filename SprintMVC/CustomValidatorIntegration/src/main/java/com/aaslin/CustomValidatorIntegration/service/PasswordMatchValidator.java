package com.aaslin.CustomValidatorIntegration.service;

import com.aaslin.CustomValidatorIntegration.annotation.*;
import com.aaslin.CustomValidatorIntegration.dto.UserRegistration;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, UserRegistration>{	
	@Override
	public void initialize(PasswordMatch constraintAnnotation) { }	
	@Override
	public boolean isValid(UserRegistration user, ConstraintValidatorContext context) {
		if(user==null) {
			return false;
		}
		return user.getPassword().equals(user.getConfirmPassword());
	}

}
