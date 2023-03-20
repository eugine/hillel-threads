package ua.ithillel.streams.figure;

public record Squire(int side) implements Figure {
    @Override
    public double area() {
        return side * side;
    }

    @Override
    public FigureType type() {
        return FigureType.SQUIRE;
    }
}
