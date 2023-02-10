package ua.ithillel.hausaufgabe.hw2.part3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircleTest {

    @Test
    void shouldCalculateArea() {
        double actual = new Circle(10).area();

        assertEquals(314.159, actual, 0.001);
    }

}
