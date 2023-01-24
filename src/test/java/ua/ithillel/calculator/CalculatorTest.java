package ua.ithillel.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.2

class CalculatorTest {

    @Test
    void shouldAddInts() {
        var calculator = new Calculator();

//        assert calculator.add(1, 2) == 4;
        assertEquals(3, calculator.add(1,2));
    }

}