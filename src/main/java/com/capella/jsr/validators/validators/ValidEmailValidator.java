package com.capella.jsr.validators.validators;

import com.capella.jsr.validators.date.ValidEmail;
import org.slf4j.Logger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Email Id validator
 */
public class ValidEmailValidator implements ConstraintValidator<ValidEmail, Object> {
    public static final Logger LOGGER = getLogger(ValidEmailValidator.class);

    public static final String EMAIL_PATTERN = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
    private ValidEmail validEmail = null;

    public void initialize(ValidEmail dateRange) {
        this.validEmail = dateRange;
    }

    /**
     * Is give email adress valid.
     *
     * @param object                     Date Range object
     * @param constraintValidatorContext ${#ConstraintValidatorContext}
     * @return Returns if dates are in valid range
     */
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        if (object != null) {
            isValid = isValidEmailAddress((String) object);
        }
        return isValid;
    }


    private boolean isValidEmailAddress(String email) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(EMAIL_PATTERN);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}