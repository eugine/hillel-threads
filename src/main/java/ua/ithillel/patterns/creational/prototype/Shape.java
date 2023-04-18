package ua.ithillel.patterns.creational.prototype;

import lombok.Getter;

@Getter
public abstract class Shape {
    private final int x;
    private final int y;
    private final int color;

    public Shape(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Shape(Shape source) {
        this.x = source.x;
        this.y = source.y;
        this.color = source.color;
    }

    public abstract Shape clone();
}
