package com.example.kartiksapra.watchlist.entity.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// Custom annotation to validate the priority field (L, M, H)

@Target(ElementType.FIELD)  // Specifies that this annotation can be used on fields
@Retention(RetentionPolicy.RUNTIME)  // Retains the annotation at runtime
@Constraint(validatedBy = PriorityAnnotationLogic.class)  // Specifies the validator class that handles the validation logic
public @interface Priority 
{
    // Default error message if validation fails
    String message() default "Please enter L, M, H only";
    
    // Allows the specification of validation groups (not used here)
    Class<?>[] groups() default {};
    
    // Allows the attachment of metadata (not used here)
    Class<? extends Payload>[] payload() default {};
}
