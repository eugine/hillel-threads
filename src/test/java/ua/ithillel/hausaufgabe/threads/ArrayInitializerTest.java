package ua.ithillel.hausaufgabe.threads;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.DoubleStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayInitializerTest {

    @Test
    void shouldInitArray() {
        var array = new double[10];
        Arrays.fill(array, 10);

        ArrayInitializer.init(array);

        var countWithInitialValue = DoubleStream.of(array)
                .filter(value -> Math.abs(value - 10) < 0.001)
                .count();
        assertTrue(countWithInitialValue < 5);

        for (int i = 0; i < array.length / 2; i++) {
            assertEquals(array[i], array[i + array.length / 2], 0.001);
        }
    }
}