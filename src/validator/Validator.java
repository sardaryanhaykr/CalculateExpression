package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hayk on 24.07.2021.
 */
public class Validator {
    private final static String regularExpression = "-?[0-9]+(?:[,.][0-9]+)?";
    private static final Pattern DOUBLE_pATTERN=Pattern.compile(regularExpression);

    private Validator() {
    }

    public static boolean isDouble(String expression) {
        Matcher matcher = DOUBLE_pATTERN.matcher(expression);
        return matcher.matches();
    }
}
