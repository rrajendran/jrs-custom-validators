package com.capella.jsr.validators.date;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Ramesh Rajendran
 *
 * @ValidDate()
 * String date
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateRangeValidator.class)
public @interface DateRange {
  String[] fields();
  String format() default "dd-MM-yyyy";
  String message() default "Date range is not valid";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}