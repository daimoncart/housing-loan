package plans;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {

    public static final int MONTHS_IN_YEAR = 12;
    public static BigDecimal calculateEmi(double principalAmount, int durationInMonths, double interest) {
        var installment =  BigDecimal.valueOf(
            principalAmount *
                interest/ MONTHS_IN_YEAR / 100 * Math.pow((1 + interest/ MONTHS_IN_YEAR / 100), durationInMonths) /
                (Math.pow((1 + interest/MONTHS_IN_YEAR/100), durationInMonths) -1)
        );
        return installment.setScale(2, RoundingMode.UP);
    }
}
