package ua.ithillel.threads.advanced.locks;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.random.RandomGenerator;

import static ua.ithillel.utils.LogUtils.log;

public class LockPetrolStation implements PetrolStation {
    private final static RandomGenerator random = RandomGenerator.getDefault();

    private double volume;
    private final Lock lock;

    public LockPetrolStation(double volume) {
        this.volume = volume;
        this.lock = new ReentrantLock();
    }

    @Override
    @SneakyThrows
    public void fuel(double volume) {
        lock.lock();
        try {
            log("Decrement petrol volume by %s", volume);
            this.volume -= volume;
            var sleep = random.nextInt(1000, 5000);
            Thread.sleep(sleep);
            log("Slept %s", sleep);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public double volume() {
        return volume;
    }


}
