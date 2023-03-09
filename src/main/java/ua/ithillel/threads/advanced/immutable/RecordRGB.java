package ua.ithillel.threads.advanced.immutable;

public record RecordRGB(String name, int red, int green, int blue) {
    public RecordRGB {
        check();
    }

    private void check() {
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

    public RecordRGB invert() {
        return new RecordRGB("Inverse of " + name, 255 - red, 255 - green, 255 - blue);
    }
}
