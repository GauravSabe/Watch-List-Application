package com.example.kartiksapra.watchlist.entity.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// Custom annotation for validating movie ratings

@Target(ElementType.FIELD)  // Applies this validation to fields only
@Retention(RetentionPolicy.RUNTIME)  // Retains this annotation at runtime
@Constraint(validatedBy = RatingAnnotationLogic.class)  // Links to the logic class that implements validation
public @interface Rating 
{
	// Default error message when validation fails
	String message() default "Please enter value b/w 5 and 10";
	
	Class<?>[] groups() default {};  // Grouping the validation constraints
	Class<? extends Payload>[] payload() default {};  // Carrying additional data during validation
}
