package ua.ithillel.threads.basic;

public class ThreadsExample {
    public static void main(String[] args) throws InterruptedException {

        var thread1 = new Thread(ThreadsExample::printThreadName, "thread-1");
        var thread2 = new Thread(ThreadsExample::printThreadName, "thread-2");

        printThreadName(); //main

        thread1.start(); // thread-1

        printThreadName(); //main

        thread2.start(); // thread-2

        printThreadName(); //main
    }

    public static void printThreadName() {
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }
}
