package tests.age_test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AdultTest {

    private static String birthDate;
    private static String message;

    private final static String ADULT_AGE_MESSAGE = "You have been 18 years already";
    private final static String YOUNG_AGE_MESSAGE = "You are younger 18 years";

    public static void main(String[] args) {

        System.out.println("Please, input your date of birth in format yyyy-mm-dd");
        String regex = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";

        Scanner inputAnswer = new Scanner(System.in);
        birthDate = inputAnswer.next();

        while (!birthDate.matches(regex)) {
            System.out.println("Please, enter correct your date of birth");
            birthDate = inputAnswer.next();
        }
        checkAge(birthDate);
    }

    static String checkAge(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthLocalDate = LocalDate.parse(birthDate, formatter);
        long yearsBetween = ChronoUnit.YEARS.between(birthLocalDate, LocalDate.now());

        message = (yearsBetween >= 18) ? ADULT_AGE_MESSAGE : YOUNG_AGE_MESSAGE;

        System.out.println(message);
        return message;
    }
}
