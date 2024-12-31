package com.example.kartiksapra.watchlist.entity.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// Custom validator to check if the priority field contains only L, M, or H
public class PriorityAnnotationLogic implements ConstraintValidator<Priority, String> 
{
    // Checks if the priority value is a single character and is either 'L', 'M', or 'H'
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) 
	{
		// Ensure the value is a single character and is one of L, M, or H
		return value.trim().length() == 1 && "LHM".contains(value.trim());
	}
}
