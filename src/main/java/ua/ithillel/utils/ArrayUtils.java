package ua.ithillel.utils;

import java.util.Random;
import java.util.stream.IntStream;

public class ArrayUtils {

    public static int[] randomArray(int bound, int size) {
        var random = new Random();
        return IntStream.generate(() -> random.nextInt(bound))
                .limit(size)
                .toArray();
    }
}
