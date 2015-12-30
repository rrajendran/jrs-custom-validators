package com.capella.jsr.validators.date;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Date string validator
 */
public class DateRangeValidator implements ConstraintValidator<DateRange, Object> {
    DateRange dateRange = null;
    public void initialize(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    /**
     * is date valid
     * @param object                    Date Range object
     * @param constraintValidatorContext    ${#ConstraintValidatorContext}
     * @return                              Returns if dates are in valid range
     */
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if(object != null){
            try {
                String startDateValue = BeanUtils.getProperty(object, dateRange.fields()[0]);
                String endDateValue = BeanUtils.getProperty(object, dateRange.fields()[1]);

                return DateValidator.isDatesInRange(startDateValue,endDateValue, dateRange.format());

            } catch (Exception e) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate(
                       e.getMessage()
                )
                        .addConstraintViolation();
               return false;
            }
        }

        return false;
    }



}