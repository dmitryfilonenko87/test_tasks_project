package tests.age_test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static enums.Constant.Message.*;
import static utils.AgeUtils.birthDate;
import static utils.AgeUtils.isEnteredBirthDateCorrect;

public class AdultTest {

    private static String message;

    public static void main(String[] args) {
        isEnteredBirthDateCorrect();
        checkAge(birthDate);
    }

    /**
     * The method accepts a date as a string as input, returns it to LocalDate
     * and and compares it with the current date, return the message if you have been 18 years
     **/

    static String checkAge(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthLocalDate = LocalDate.parse(birthDate, formatter);
        long yearsBetween = ChronoUnit.YEARS.between(birthLocalDate, LocalDate.now());

        message = (yearsBetween >= 18) ? ADULT_AGE_MESSAGE : YOUNG_AGE_MESSAGE;

        System.out.println(message);
        return message;
    }
}
