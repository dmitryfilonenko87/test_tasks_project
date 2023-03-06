package tests.age_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static enums.Constant.BirthDate.*;
import static enums.Constant.Message.*;
import static enums.Date.*;
import static tests.age_test.AdultTest.checkAge;

public class UnitTest {

    @Test
    public void checkAgeLess18Years () {
        Assert.assertEquals(checkAge(BIRTH_DAY_AGE_LESS_18_YEARS), YOUNG_AGE_MESSAGE);
    }

    @Test
    public void checkAgeMore18Years () {
        Assert.assertEquals(checkAge(BIRTH_DAY_AGE_MORE_18_YEARS), ADULT_AGE_MESSAGE);
    }

    @Test
    public void checkAgeEquals18Years () {
        Assert.assertEquals(checkAge(TODAY_MINUS_18_YEARS.toString()), ADULT_AGE_MESSAGE);

    }

    @Test
    public void checkAgeEquals18YearsAndOneDay () {
        Assert.assertEquals(checkAge(TODAY_MINUS_18_YEARS_AND_ONE_DAY.toString()), ADULT_AGE_MESSAGE);
    }

    @Test
    public void checkAgeEquals18YearsMinusOneDay () {
        Assert.assertEquals(checkAge(TODAY_MINUS_18_YEARS_AND_PLUS_ONE_DAY.toString()), YOUNG_AGE_MESSAGE);
    }

}
