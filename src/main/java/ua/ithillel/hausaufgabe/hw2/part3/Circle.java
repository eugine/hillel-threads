package ua.ithillel.hausaufgabe.hw2.part3;

public class Circle implements Figure {

    private static final double PI = 3.1415;
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }
}
