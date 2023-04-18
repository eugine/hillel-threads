package ua.ithillel.patterns.creational.prototype;

import lombok.Getter;

@Getter
public class Squire extends Shape {
    private final int width;
    private final int height;

    public Squire(int x, int y, int width, int height, int color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    public Squire(Squire source) {
        super(source);
        this.width = source.width;
        this.height = source.height;
    }

    @Override
    public Squire clone() {
        return new Squire(this);
    }
}
