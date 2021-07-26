package model;

import model.ValueExpreession;
import util.StringUtil;

/**
 * Created by Hayk on 24.07.2021.
 */
public class OperatorExpression implements Expression {

    private final String expression;
    private ValueExpreession expreessionL;
    private ValueExpreession expreessionR;
    private Operator operator;

    OperatorExpression(String expression) {
        this.expression = expression;
        setOperator(expression.charAt(StringUtil.posOperator(expression)));
        setExpreessionL();
        setExpreessionR();
    }

    private void setOperator(char s) {
        switch (s) {
            case '+':
                this.operator = Operator.PLUS;
                break;
            case '-':
                this.operator = Operator.MINUS;
                break;
            case '*':
                this.operator = Operator.MULTIPLY;
                break;
            case '/':
                this.operator = Operator.DIVIDE;
                break;
        }
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
            case MULTIPLY:
                return expreessionL.calculate() * expreessionR.calculate();

            case DIVIDE: {
                return expreessionL.calculate() / expreessionR.calculate();
            }

            case PLUS:
            case MINUS: {
                return expreessionL.calculate() + expreessionR.calculate();
            }
        }
        return 0;
    }
}
