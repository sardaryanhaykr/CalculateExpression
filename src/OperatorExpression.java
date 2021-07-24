import util.StringUtil;

/**
 * Created by Hayk on 24.07.2021.
 */
public class OperatorExpression implements Expression {
    char operator;
    ValueExpreession expreessionL;
    ValueExpreession expreessionR;

    public OperatorExpression(String expression) {
        if (expression.charAt(StringUtil.posOperator(expression)) == '-') {
            this.expreessionL = new ValueExpreession(expression.substring(0, StringUtil.posOperator(expression)));
            this.expreessionR = new ValueExpreession(expression.substring(StringUtil.posOperator(expression), expression.length()));
            this.operator = expression.charAt(StringUtil.posOperator(expression));
        } else {
            this.expreessionL = new ValueExpreession(expression.substring(0, StringUtil.posOperator(expression)));
            this.expreessionR = new ValueExpreession(expression.substring(StringUtil.posOperator(expression) + 1, expression.length()));
            this.operator = expression.charAt(StringUtil.posOperator(expression));
        }
    }

    @Override
    public double calculate() {
        switch (this.operator) {
            case '*':
                return expreessionL.calculate() * expreessionR.calculate();

            case '/': {
                return expreessionL.calculate() / expreessionR.calculate();
            }

            case '+': {
                return expreessionL.calculate() + expreessionR.calculate();
            }

            case '-': {
                return expreessionL.calculate() + expreessionR.calculate();
            }
        }
        return 0;
    }
}
