package ua.ithillel.testing;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Arithmetical progression formula: start + diff * n
 * 1) 1 -> 2 -> 3 -> 4 -> .... -> (1 + n)
 * start: 1
 * diff: 1
 * 2) 2 -> 5 -> 8 -> 11 -> ... -> (2 + 3*n)
 * start: 2
 * diff: 3
 */
public class ArithmeticProgression {

    public static int[] createProgression(int start, int diff, int size) {
        return IntStream.range(0, size)
                .map(index -> start + diff * index)
                .toArray();
    }

    public static void initProgression(int[] dest, int start, int diff) {
        for (int i = 0; i < dest.length; i++) {
            dest[i] = start + i * diff;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createProgression(1, 1, 10)));

//        int[] array = new int[10];
//        initProgression(array, 1);
//        System.out.println(Arrays.toString(array));
//
        System.out.println(Arrays.toString(createProgression(2, 3, 10)));
//        initProgression(array, 2, 3);
//        System.out.println(Arrays.toString(array));
    }
}
