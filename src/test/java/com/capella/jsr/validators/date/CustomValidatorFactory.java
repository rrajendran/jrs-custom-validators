package com.capella.jsr.validators.date;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * Created by ramesh on 16/10/2015.
 */
public class CustomValidatorFactory {

    public static Validator getValidator(){
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

}
