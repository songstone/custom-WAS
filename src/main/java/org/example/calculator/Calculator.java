package org.example.calculator;

import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(
        new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator()
    );

//    public static int calculate(int operand1, String operator, int operand2) {
//        return ArithmeticOperator.calculate(operand1, operator, operand2);
//    }

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return arithmeticOperators.stream()
            .filter(ao -> ao.supports(operator))
            .map(ao -> ao.calculate(operand1, operand2))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다"));
    }
}
