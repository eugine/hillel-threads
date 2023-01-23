package ua.ithillel.threads;

public class ThreadsExample {
    public static void main(String[] args) throws InterruptedException {

        var thread1 = new Thread(ThreadsExample::printThreadName, "thread-1");
        var thread2 = new Thread(ThreadsExample::printThreadName, "thread-2");

        printThreadName();

//        thread1.start();
//
//        printThreadName();
//
//        thread2.start();
//
//        printThreadName();
    }

    public static void printThreadName() {
        var localVariable1 = 10;
        var localVariable2 = 20;
        System.out.println("Thread name: " + Thread.currentThread().getName());

    }
}
