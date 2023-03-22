package ua.ithillel.lambda.classes;

import ua.ithillel.utils.LogUtils;

import static ua.ithillel.utils.LogUtils.log;

public class AnonymousClassExample {

    public void process() {
        class LocalRunnable implements Runnable {

            @Override
            public void run() {
                log("Local runnable");
            }
        }
        var localRunnable = new LocalRunnable();

        var anonymousRunnable = new Runnable() {

            @Override
            public void run() {
                log("Anonymous runnable");
            }
        };

        localRunnable.run();
        anonymousRunnable.run();
    }

    public static void main(String[] args) {
        new AnonymousClassExample().process();
    }
}
