package util;

/**
 * Created by Hayk on 24.07.2021.
 */
public class StringUtil {
    private StringUtil() {
    }

    public static int posOperator(String expression) {
        int pos = -1;
        if (expression.indexOf("+") > 0) {
            pos = expression.indexOf("+");
        } else if (expression.indexOf("-") == 0 && expression.indexOf("-",1)>0) {
            pos = expression.indexOf("-",1);
        } else if (expression.indexOf("-") > 0) {
            pos = expression.indexOf("-");
        } else if (expression.indexOf("/") > 0) {
            pos = expression.indexOf("/");
        } else if (expression.indexOf("*") > 0) {
            pos = expression.indexOf("*");
        }
        return pos;
    }
}
