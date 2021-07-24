package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hayk on 24.07.2021.
 */
public class Validator {
    private Validator() {
    }

    public static boolean isDouble(String expression) {
        String regularExpression = "-?[0-9]+(?:[,.][0-9]+)?";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(expression);
        return matcher.matches();
    }
}
