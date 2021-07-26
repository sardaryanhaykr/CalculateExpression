package model;

import validator.Validator;

/**
 * Created by Hayk on 24.07.2021.
 */
public class ValueExpreession implements Expression {
    private final String expression;

    public ValueExpreession(String expression) {
        this.expression = expression;
    }

    @Override
    public double calculate() {
        if (Validator.isDouble(expression)) {
            return Double.parseDouble(expression);
        } else {
            return new OperatorExpression(expression).calculate();
        }
    }
}
