#jrs-custom-validators
[![Build Status](https://travis-ci.org/rrajendran/jsr-custom-validators.svg)](https://travis-ci.org/rrajendran/jsr-custom-validators)
<<<<<<< HEAD

##Adding custom JSR-303 Validators


##@ValidDate
Adding custom JSR-303 Validators
=======
>>>>>>> 019687a03f42338bfa8e5bffc7072113846432b4

##Adding custom JSR-303 Validators


##@ValidDate
Validates if the give string has a valid startDate or not. Can provide startDate format also. Default is yyyy-MM-dd
<br />
Example
<pre>
    @ValidDate(format = "dd-MM-yyyy")
    private String date;
</pre>


##@DateRange
<pre>
@DateRange(fields = {"startDate","endDate"},format = "dd-MM-yyyy", message = "Given dates are not in valid range")
public class DateRangeObject {
    private String startDate;
    private String endDate;
}
</pre>
=======
Validates if the give string has a valid date or not. Can provide date format also. Default is yyyy-MM-dd
<br />
Example
<br />
##@ValidDate(format="dd-MM-yyyy")
<br />
String date;

##@ValidEmail
<pre>
    @ValidEmail(message = "This email is not valid")
    private String email;
</pre> 
##How to use it
<pre>
    Set<ConstraintViolation<DateRangeObject>> validate = Validation.buildDefaultValidatorFactory().getValidator().validate(dateObject);
</pre>