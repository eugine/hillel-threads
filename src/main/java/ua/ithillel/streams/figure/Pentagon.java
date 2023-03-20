package ua.ithillel.streams.figure;

public class Pentagon implements Figure{
    @Override
    public double area() {
        throw new UnsupportedOperationException("Pentagon area is not supported");
    }

    @Override
    public FigureType type() {
        return FigureType.PENTAGON;
    }
}
