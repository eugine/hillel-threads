package ua.ithillel.hausaufgabe.threads.advanced;

import ua.ithillel.utils.LogUtils;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinArrayInitializer {

    public static void main(String[] args) {
        double[] data = new double[40];
        Arrays.fill(data, 10);

        var pool = new ForkJoinPool();
        pool.invoke(new ArrayInitializerTask(data, 0, data.length));
        System.out.println(Arrays.toString(data));
    }

    private static class ArrayInitializerTask extends RecursiveAction {
        private final double[] data;
        private final int start;
        private final int end;

        public ArrayInitializerTask(double[] data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            LogUtils.log("Compute range [%s,%s]", start, end);
            if (end - start <= 10) {
                for (int i = start; i < end; i++) {
                    var offset = i / 5.0;
                    data[i] = data[i] * Math.sin(0.2 + offset) * Math.cos(0.2 + offset) * Math.cos(0.4 + offset);
                }
            } else {
                int middle = (start + end) / 2;
                var left = new ArrayInitializerTask(data, start, middle);
                var right = new ArrayInitializerTask(data, middle, end);

                left.fork();
                right.fork();

                left.join();
                right.join();
            }
        }
    }
}
