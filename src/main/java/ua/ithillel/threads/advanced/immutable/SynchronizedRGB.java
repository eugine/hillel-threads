package ua.ithillel.threads.advanced.immutable;

import ua.ithillel.utils.LogUtils;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class SynchronizedRGB {

    private int red;
    private int green;
    private int blue;
    private String name;


    public SynchronizedRGB(String name, int red, int green, int blue) {
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

    public void set(String name, int red, int green, int blue) {
        check(red, green, blue);
        synchronized (this) {
            this.name = name;
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
    }

    public synchronized int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void invert() {
        red = 255 - red;
        green = 255 - green;
        blue = 255 - blue;
        name = "Inverse of " + name;
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