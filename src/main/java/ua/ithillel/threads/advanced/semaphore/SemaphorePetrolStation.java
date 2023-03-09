package ua.ithillel.threads.advanced.semaphore;

import lombok.SneakyThrows;
import ua.ithillel.threads.advanced.locks.PetrolStation;

import java.util.concurrent.Semaphore;
import java.util.random.RandomGenerator;

import static ua.ithillel.utils.LogUtils.log;

public class SemaphorePetrolStation implements PetrolStation {
    private final static RandomGenerator random = RandomGenerator.getDefault();

    private double volume;
    private final Semaphore semaphore;

    public SemaphorePetrolStation(double volume, int numberOfFillingStation) {
        this.volume = volume;
        this.semaphore = new Semaphore(numberOfFillingStation);
    }

    @SneakyThrows
    public void fuel(double volume) {
        semaphore.acquire();
        try {
            log("Decrement petrol volume by %s", volume);
            synchronized (this) {
                this.volume -= volume;
            }
            var sleep = random.nextInt(1000, 5000);
            Thread.sleep(sleep);
            log("Slept %s", sleep);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public double volume() {
        return volume;
    }

}
