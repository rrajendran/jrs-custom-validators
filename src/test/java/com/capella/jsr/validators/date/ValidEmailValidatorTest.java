package com.capella.jsr.validators.date;

import com.capella.jsr.validators.entity.EmailObject;
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
public class ValidEmailValidatorTest {
    private String emailId;
    private boolean result;

    @Parameters(name = "{index}: Email id - {0} isValid {1}")
    public static Collection<Object[]> data() {
        return asList(new Object[][]{
                {"me@example.com", true},
                {"email@domain.web", true},
                {"a.nonymous@example.com", true},
                {"firstname+lastname@domain.com", true},
                {"1234567890@domain.com", true},
                {"email@domain-one.com", true},
                {"_______@domain.com", true},
                {"email@domain.name", true},
                {"email@domain.co.jp", true},
                {"email@111.222.333.444", true},
                {"firstname-lastname@domain.com", true},
                {"\"email\"@domain.com", false},
                {"plainaddress", false},
                {"email@domain..com", false},
                {"email@-domain.com", false},
                {"email@domain", false},
                {"email@domain.com (Joe Smith)", false},
                {"あいうえお@domain.com", false},
                {"idna_in_clear(?)_text@例子.测试.مثال.آزمایشی", false},
                {"email..email@domain.com", false},
                {"email.@domain.com", false},
                {".email@domain.com", false},
                {"email@domain@domain.com", false},
                {"email.domain.com", false},
                {"Joe Smith <email@domain.com>", false},
                {"@domain.com", false},
                {"#@%^%#$@#$@#.com", false},
                {"this\\ still\\\"not\\\\allowed@example.com", false},
                {"just\"not\"right@example.com", false},
                {"a\"b(c)d,e:f;g<h>i[j\\k]l@example.com", false},
        });
    }

    public ValidEmailValidatorTest(String emailId, boolean result) {
        this.emailId = emailId;
        this.result = result;
    }

    @Test
    public void test() {
        EmailObject emailObject = EmailObject.EmailObjectBuilder.getInstance().email(this.emailId).build();
        Set<ConstraintViolation<EmailObject>> validate = CustomValidatorFactory.getValidator().validate(emailObject);
        assertEquals(this.result, validate.size() == 0);
    }

}
