package ua.ithillel.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublePrecisionIssueTest {

    @Test
    void shouldCompareDoubles() {
        double actual = 4.01 * 4.01;

        double expected = 16.0801;

        //delta
        double delta = Math.abs(actual - expected);

        //assert
        assertEquals(expected, actual, 0.00001);

    }

}