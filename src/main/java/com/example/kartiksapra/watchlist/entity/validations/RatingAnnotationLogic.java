package com.example.kartiksapra.watchlist.entity.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// Logic for validating the Rating annotation
public class RatingAnnotationLogic implements ConstraintValidator<Rating, Float>
{
	// Method that checks if the value falls within the valid rating range (5 to 10)
	@Override
	public boolean isValid(Float value, ConstraintValidatorContext context) 
	{
		// Returns true if the value is greater than 5 and less than or equal to 10, otherwise false
		return value > 5 && value <= 10;
	}
}
