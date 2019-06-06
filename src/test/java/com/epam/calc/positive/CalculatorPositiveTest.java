package com.epam.calc.positive;

import com.epam.calc.Calculator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class CalculatorPositiveTest {

    @Test
    void testAddition() {
        assertThat(Calculator.calculate("2 + 3"), is(equalTo(5)));
    }

    @Test
    void testSubtraction() {
        assertThat(Calculator.calculate("7 - 8"), is(equalTo(-1)));
    }

    @Test
    void testMultiplication() {
        assertThat(Calculator.calculate("2 * 3"), is(equalTo(6)));
    }

    @Test
    void testDivision() {
        assertThat(Calculator.calculate("12 / 3"), is(equalTo(4)));
    }
}
