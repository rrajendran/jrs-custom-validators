import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Set;

import static java.util.Arrays.asList;
import static javax.validation.Validation.buildDefaultValidatorFactory;
import static org.junit.Assert.assertEquals;

/**
 * Created by ramesh on 16/10/2015.
 */
@RunWith(Parameterized.class)
public class ValidDateValidatorTest {
    private String date;
    private boolean result;
    private Validator validator = buildDefaultValidatorFactory().getValidator();

    @Parameters(name = "{index}: Date : {0}] Expected :{1}")
    public static Collection<Object[]> data() {
        return asList(new Object[][]{
                {"01-01-2001", true},
                {"31-09-2015", false}, // Max date 30 test
                {"29-02-2016", true}, // leap year test
        });
    }

    public ValidDateValidatorTest(String date, boolean result) {
        this.date = date;
        this.result = result;
    }


    @Test
    public void test(){
        DateObject date = DateObject.DateObjectBuilder.aDateObject().date(this.date).build();
        Set<ConstraintViolation<DateObject>> validate = validator.validate(date);
        for (ConstraintViolation<DateObject> dateObjectConstraintViolation : validate) {
            System.out.println("Voilations : " + dateObjectConstraintViolation.getInvalidValue() + " - " + dateObjectConstraintViolation.getMessage());
        }
        System.out.println(validate.size());
        assertEquals(this.result, validate.size() == 0);
    }

}
