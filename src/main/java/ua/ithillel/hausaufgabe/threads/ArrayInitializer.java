package ua.ithillel.hausaufgabe.threads;

import java.util.Arrays;

public class ArrayInitializer {

    public static void init(double[] array) {
        int half = array.length / 2;

        var array1 = Arrays.copyOfRange(array, 0, half);
        var array2 = Arrays.copyOfRange(array, 0, half);

        var thread1 = new Thread(new ArrayInitializerTask(array1));
        var thread2 = new Thread(new ArrayInitializerTask(array2));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.arraycopy(array1, 0, array, 0, half);
        System.arraycopy(array2, 0, array, half, half);
    }

    public static void main(String[] args) {
        double[] array = new double[1_000];
        Arrays.fill(array, 10);
        long start = System.currentTimeMillis();
        init(array);
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }

    private record ArrayInitializerTask(double[] array) implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < array.length; i++) {
                var offset = i / 5.0;
                array[i] = array[i] * Math.sin(0.2 + offset) * Math.cos(0.2 + offset) * Math.cos(0.4 + offset);
            }
        }
    }
}
