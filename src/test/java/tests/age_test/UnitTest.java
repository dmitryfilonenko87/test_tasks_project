package tests.age_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static tests.age_test.AdultTest.checkAge;

public class UnitTest {

    private final static String ADULT_AGE_MESSAGE = "You have been 18 years already";
    private final static String YOUNG_AGE_MESSAGE = "You are younger 18 years";

    final private static String BIRTH_DAY_AGE_LESS_18_YEARS = "2010-05-05";
    final private static String BIRTH_DAY_AGE_MORE_18_YEARS = "2000-05-05";
    final private static LocalDate TODAY_MINUS_18_YEARS = LocalDate.now().minusYears(18);
    final private static LocalDate TODAY_MINUS_18_YEARS_AND_ONE_DAY = TODAY_MINUS_18_YEARS.minusDays(1);
    final private static LocalDate TODAY_MINUS_18_YEARS_AND_PLUS_ONE_DAY = TODAY_MINUS_18_YEARS.plusDays(1);

    @Test
    public void checkAgeLess18Years () {
        String result = YOUNG_AGE_MESSAGE;
        Assert.assertEquals(checkAge(BIRTH_DAY_AGE_LESS_18_YEARS), result);
    }

    @Test
    public void checkAgeMore18Years () {
        String result = ADULT_AGE_MESSAGE;
        Assert.assertEquals(checkAge(BIRTH_DAY_AGE_MORE_18_YEARS), result);
    }

    @Test
    public void checkAgeEquals18Years () {
        String result = ADULT_AGE_MESSAGE;
        Assert.assertEquals(checkAge(TODAY_MINUS_18_YEARS.toString()), result);

    }

    @Test
    public void checkAgeEquals18YearsAndOneDay () {
        String result = ADULT_AGE_MESSAGE;
        Assert.assertEquals(checkAge(TODAY_MINUS_18_YEARS_AND_ONE_DAY.toString()), result);
    }

    @Test
    public void checkAgeEquals18YearsMinusOneDay () {
        String result = YOUNG_AGE_MESSAGE;
        Assert.assertEquals(checkAge(TODAY_MINUS_18_YEARS_AND_PLUS_ONE_DAY.toString()), result);
    }

}
