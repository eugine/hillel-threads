package ua.ithillel.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
//https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.2

class CalculatorTest {

    @Test
    void shouldAddIns() {
        Calculator calculator = new Calculator();

        assertEquals(3, calculator.add(1,2));
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                calculator.add(1,2);
            }
        });
    }

    @Test
    void shouldMatchStrings() {
        var initial = "121";
        var reversed = new StringBuilder("121").toString();

        assertEquals(initial, reversed);
    }

    @Test
    void shouldAddIns2() {
        Calculator calculator = new Calculator();

        assertEquals(4, calculator.add(2,2));
    }
    @Test
    void shouldAddIns3() {
        Calculator calculator = new Calculator();

        assertEquals(6, calculator.add(4,2));
    }
    @Test
    void shouldAddIns4() {
        Calculator calculator = new Calculator();

        assertEquals(6, calculator.add(4,2));
    }

}