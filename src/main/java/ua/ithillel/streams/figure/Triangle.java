package ua.ithillel.streams.figure;

import static ua.ithillel.streams.figure.FigureType.TRIANGLE;

public record Triangle(double side, double height) implements Figure{

    @Override
    public double area() {
        return 0.5 * side * height;
    }

    @Override
    public FigureType type() {
        return TRIANGLE;
    }
}
