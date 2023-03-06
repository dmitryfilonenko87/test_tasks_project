package enums;

import java.time.LocalDate;

public class Date {
    public static final LocalDate TODAY_MINUS_18_YEARS = LocalDate.now().minusYears(18);
    public static final LocalDate TODAY_MINUS_18_YEARS_AND_ONE_DAY = TODAY_MINUS_18_YEARS.minusDays(1);
    public static final LocalDate TODAY_MINUS_18_YEARS_AND_PLUS_ONE_DAY = TODAY_MINUS_18_YEARS.plusDays(1);
}
