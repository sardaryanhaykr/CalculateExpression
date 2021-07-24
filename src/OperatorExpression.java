import util.StringUtil;

/**
 * Created by Hayk on 24.07.2021.
 */
public class OperatorExpression implements Expression {
    private char operator;
    private String expression;
    private ValueExpreession expreessionL;
    private ValueExpreession expreessionR;


    OperatorExpression(String expression) {
        this.expression = expression;
        setOperator();
        setExpreessionL();
        setExpreessionR();
    }

    private void setOperator() {
        this.operator = expression.charAt(StringUtil.posOperator(expression));
    }

    private void setExpreessionL() {
        this.expreessionL = new ValueExpreession(expression.substring(0, StringUtil.posOperator(expression)));
    }

    private void setExpreessionR() {
        if (expression.charAt(StringUtil.posOperator(expression)) == '-') {
            this.expreessionR = new ValueExpreession(expression.substring(StringUtil.posOperator(expression)));
        } else {
            this.expreessionR = new ValueExpreession(expression.substring(StringUtil.posOperator(expression) + 1));
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

            case '+':
            case '-': {
                return expreessionL.calculate() + expreessionR.calculate();
            }
        }
        return 0;
    }
}
