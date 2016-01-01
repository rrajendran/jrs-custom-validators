package com.capella.jsr.validators.validators;

import com.capella.jsr.validators.date.ValidDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Date string validator
 */
public class ValidDateValidator implements ConstraintValidator<ValidDate, String> {
    ValidDate validDate = null;

    public void initialize(ValidDate dateRange) {
        validDate = dateRange;
    }

    /**
     * is date valid
     *
     * @param dateString                 Date as string
     * @param constraintValidatorContext ${#ConstraintValidatorContext}
     * @return Returns if date is valid or not
     */
    public boolean isValid(String dateString, ConstraintValidatorContext constraintValidatorContext) {
        if (dateString != null) {
            try {
                return DateValidator.isDateValid(dateString, validDate.format());

            } catch (Exception e) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate(
                        validDate.message() + " - " + e.getMessage()
                )
                        .addConstraintViolation();
                return false;
            }
        }

        return false;
    }
}