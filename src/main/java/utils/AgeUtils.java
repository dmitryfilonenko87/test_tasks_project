package utils;

import java.util.Scanner;

import static enums.Constant.Message.ENTER_CORRECT_BIRTHDAY_MESSAGE;
import static enums.Constant.Message.ENTER_YOUR_BIRTHDAY_MESSAGE;

public class AgeUtils {
    public static String birthDate;

    /**
     * The method using a regular expression checks if the date entered is correct.
     **/

    public static String isEnteredBirthDateCorrect() {
        System.out.println(ENTER_YOUR_BIRTHDAY_MESSAGE);
        String regex = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";

        Scanner inputAnswer = new Scanner(System.in);
        birthDate = inputAnswer.next();

        while (!birthDate.matches(regex)) {
            System.out.println(ENTER_CORRECT_BIRTHDAY_MESSAGE);
            birthDate = inputAnswer.next();
        }
        return birthDate;
    }
}
