package ua.ithillel.streams.figure;

public record Circle(double radius) implements Figure {
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public FigureType type() {
        return FigureType.CIRCLE;
    }
}
