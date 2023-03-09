package ua.ithillel.threads.advanced.forkjoin;

import ua.ithillel.utils.LogUtils;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample  {

    public static void main(String[] args) {
        var data = new int[1000];
        Arrays.fill(data, 6);

        var pool = new ForkJoinPool();
        int result = pool.invoke(new SumTask(data, 0, data.length));

        LogUtils.log("Result: %s", result);

    }

    private static class SumTask extends RecursiveTask<Integer> {
        private final int[] data;
        private final int start;
        private final int end;

        public SumTask(int[] data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            LogUtils.log("compute");
            if (end - start < 100) {
                // If the task is small enough, compute it directly.
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += data[i];
                }
                return sum;
            } else {
                // If the task is too large, split it into smaller subtasks and fork them.
                int middle = (start + end) / 2;
                var left = new SumTask(data, start, middle);
                var right = new SumTask(data, middle, end);
                left.fork();
                right.fork();

                int leftResult = left.join();
                int rightResult = right.join();

                return leftResult + rightResult;
            }
        }
    }
}
