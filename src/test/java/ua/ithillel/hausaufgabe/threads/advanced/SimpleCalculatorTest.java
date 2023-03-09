package ua.ithillel.hausaufgabe.threads.advanced;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class SimpleCalculatorTest {

    private final SimpleCalculator calculator = new SimpleCalculator();

    @Test
    void squareSum() {
        assertThat(calculator.squareSum(3, 4), equalTo(25));
    }

}