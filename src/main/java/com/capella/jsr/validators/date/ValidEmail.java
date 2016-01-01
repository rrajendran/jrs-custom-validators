package com.capella.jsr.validators.date;

import com.capella.jsr.validators.validators.ValidEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Ramesh Rajendran
 * @DateRange() String date
 */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidEmailValidator.class)
public @interface ValidEmail {
    String message() default "Invalid e-mail address";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}