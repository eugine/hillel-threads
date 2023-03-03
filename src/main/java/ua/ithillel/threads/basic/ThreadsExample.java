package ua.ithillel.threads.basic;

public class ThreadsExample {
    public static void main(String[] args) throws InterruptedException {

        var thread1 = new Thread(new TaskAny(), "thread-1");
        var thread2 = new Thread(new TaskAny(), "thread-2");

        thread1.start(); // thread-1
        thread2.start(); // thread-2

//        Thread.sleep(1_000);

        printThreadName(); //main
        printThreadName(); //main
        printThreadName(); //main
    }

    public static void printThreadName() {
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }

    public static class TaskAny implements Runnable {

        @Override
        public void run() {
            printThreadName();
        }
    }
}
