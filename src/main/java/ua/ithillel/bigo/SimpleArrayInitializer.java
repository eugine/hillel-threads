package ua.ithillel.bigo;

import java.util.Arrays;

public class SimpleArrayInitializer {

    public static void init(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 5.0);
        }
    }

    public static void main(String[] args) {
        double[] array = new double[1_000];
        Arrays.fill(array, 10);
        long start = System.currentTimeMillis();
        init(array);
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }

}
