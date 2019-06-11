package com.epam.calc.negative;

import com.epam.calc.Calculator;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorNegativeTest {

    @Test
    void divisionByZeroShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->
                Calculator.calculate("2 / 0"));
    }

    @Test
    void calculationOfEmptyExpressionShouldThrowEmptyStackException() {
        assertThrows(EmptyStackException.class, () ->
                Calculator.calculate(""));
    }

    @Test
    void calculationOfExpressionWithUnsupportedCharsShouldThrowUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () ->
                Calculator.calculate("a + b"));
    }

    @Test
    void calculationOfExpressionWithFewOperatorsInARowShouldThrowEmptyStackException() {
        assertThrows(EmptyStackException.class, () ->
                Calculator.calculate("1 + + 2"));
    }

    @Test
    void calculationOfExpressionWithWrongNumberOfLeftParenthesesShouldThrowRuntimeException() {
        assertThrows(RuntimeException.class, () ->
                Calculator.calculate("( 1 + 2 ) ("));
    }

    @Test
    void calculationOfExpressionWithWrongNumberOfRightParenthesesShouldThrowRuntimeException() {
        assertThrows(RuntimeException.class, () ->
                Calculator.calculate("( 1 + 2 ) )"));
    }
}
