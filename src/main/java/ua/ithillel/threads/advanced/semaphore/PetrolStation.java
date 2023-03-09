package ua.ithillel.threads.advanced.semaphore;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.random.RandomGenerator;

import static ua.ithillel.utils.LogUtils.log;

public class PetrolStation {
    private double volume;
    private final Semaphore semaphore;

    public PetrolStation(double volume) {
        this.volume = volume;
        this.semaphore = new Semaphore(3);
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

    @SneakyThrows
    public static void main(String[] args) {
        var petrolStation = new PetrolStation(1_000);

        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    petrolStation.fuel(random.nextDouble(10, 50));
                }
            });
            threads.add(thread);
        }
//        var threads = IntStream.range(0, 10)
//                .mapToObj(x -> new Thread(() -> petrolStation.fuel(random.nextDouble(10, 50))))
//                .toList();
        threads.forEach(Thread::start);
        for (var thread : threads) {
            thread.join();
        }
        synchronized (petrolStation) {
            System.out.println("Remained volume: " + petrolStation.volume);
        }
    }

    private final static RandomGenerator random = RandomGenerator.getDefault();

}
