package ua.ithillel.patterns.creational.prototype;

import lombok.Getter;

@Getter
public class Circle extends Shape {
    private final int radius;

    public Circle(int x, int y, int radius, int color) {
        super(x, y, color);
        this.radius = radius;
    }

    public Circle(Circle source) {
        super(source);
        this.radius = source.radius;
    }

    @Override
    public Circle clone() {
        return new Circle(this);
    }
}
