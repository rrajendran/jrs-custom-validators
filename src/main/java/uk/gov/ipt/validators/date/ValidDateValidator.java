package uk.gov.ipt.validators.date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

/**
 *
 */
public class ValidDateValidator implements ConstraintValidator<ValidDate, Object> {
    ValidDate validDate = null;
    public void initialize(ValidDate dateRange) {
        validDate = dateRange;
    }

    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(o != null && o instanceof  String){
            try {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(validDate.format());
                dateTimeFormatter.withResolverStyle(ResolverStyle.STRICT);
                LocalDate.parse((CharSequence) o, dateTimeFormatter);
                return true;
            } catch (Exception e) {
               return false;
            }
        }

        return false;
    }
}