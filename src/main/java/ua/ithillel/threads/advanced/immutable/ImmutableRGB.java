package ua.ithillel.threads.advanced.immutable;

public class ImmutableRGB {

    private final int red;
    private final int green;
    private final int blue;
    private final String name;


    public ImmutableRGB(String name, int red, int green, int blue) {
        check(red, green, blue);
        this.name = name;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    private void check(int red, int green, int blue) {
        if (red < 0 || red > 255
                || green < 0 || green > 255
                || blue < 0 || blue > 255) {
            throw new IllegalArgumentException();
        }
    }

    public int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }

    public String getName() {
        return name;
    }

    public ImmutableRGB invert() {
        return new ImmutableRGB("Inverse of " + name, 255 - red, 255 - green, 255 - blue);
    }

    @Override
    public String toString() {
        return "SynchronizedRGB{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", name='" + name + '\'' +
                '}';
    }


}