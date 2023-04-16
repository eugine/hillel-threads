package ua.ithillel.patterns.creational.singleton;

public class Car {
    private static Car INSTANCE;

    public static Car getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Car();
        }
        return INSTANCE;
    }

    private int state;

    private Car() {

    }
}
