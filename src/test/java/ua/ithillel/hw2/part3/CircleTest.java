package ua.ithillel.hw2.part3;

import org.junit.jupiter.api.Test;
import ua.ithillel.hausaufgabe.hw2.part3.Circle;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void shouldCalculateArea() {
        assertEquals(314.15, new Circle(10).area(), 0.001);
    }

}