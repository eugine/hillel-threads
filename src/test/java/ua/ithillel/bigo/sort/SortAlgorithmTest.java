package ua.ithillel.bigo.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static ua.ithillel.utils.ArrayUtils.randomArray;

abstract class SortAlgorithmTest {

    public abstract void sort(int[] array);

    @Test
    void shouldSortArray() {
        int[] array = randomArray(10_000, 100);
        int[] expected = createExpectedArray(array);

        sort(array);

        assertArrayEquals(expected, array);
    }

    private int[] createExpectedArray(int[] array) {
        var expected = Arrays.copyOf(array, array.length);
        Arrays.sort(expected);
        return expected;
    }

}