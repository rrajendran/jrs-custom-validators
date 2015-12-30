package com.capella.jsr.validators.date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import javax.validation.ConstraintViolation;
import java.util.Collection;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created by ramesh on 16/10/2015.
 */
@RunWith(Parameterized.class)
public class DateRangeValidatorTest {
    private String startDate;
    private String endDate;
    private boolean result;

    @Parameters
    public static Collection<Object[]> data() {
        return asList(new Object[][]{
                {"01-01-2001", "01-01-2000",false},
                {"28-02-2016", "29-02-2016",true}, // leap year date range
                {"01-01-2001", "02-01-2001",true}
        });
    }

    public DateRangeValidatorTest(String startDate, String endDate, boolean result) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.result = result;
    }

    @Test
    public void test(){
        DateRangeObject dateRangeObject = DateRangeObject.DateRangeObjectBuilder.getInstance().startDate(this.startDate).endDate(this.endDate).build();

        Set<ConstraintViolation<DateRangeObject>> validate = CustomValidatorFactory.getValidator().validate(dateRangeObject);


        for (ConstraintViolation<DateRangeObject> dateObjectConstraintViolation : validate) {
            System.out.println(dateObjectConstraintViolation.getInvalidValue() + " - " + dateObjectConstraintViolation.getMessage());
        }
        assertEquals(this.result, validate.size() == 0);
    }

}
