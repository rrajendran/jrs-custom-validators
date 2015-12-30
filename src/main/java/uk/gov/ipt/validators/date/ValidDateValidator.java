package uk.gov.ipt.validators.date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Date string validator
 */
public class ValidDateValidator implements ConstraintValidator<ValidDate, String> {
    ValidDate validDate = null;
    public void initialize(ValidDate dateRange) {
        validDate = dateRange;
    }

    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {
        if(o != null){
            try {
               return isDateValid(o, validDate.format());

            } catch (Exception e) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate(
                        validDate.message() +" - " + e.getMessage()
                )
                        .addConstraintViolation();
               return false;
            }
        }

        return false;
    }

    private boolean isDateValid(final String dateToValidate, String dateFormat) throws ParseException {

        if(dateToValidate == null || dateToValidate.trim().length() == 0){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            sdf.parse(dateToValidate);
        } catch (ParseException e) {
            throw e;
        }

        return true;
    }
}