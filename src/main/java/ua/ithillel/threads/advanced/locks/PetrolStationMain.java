package ua.ithillel.threads.advanced.locks;

import lombok.SneakyThrows;
import ua.ithillel.threads.advanced.semaphore.SemaphorePetrolStation;

import java.util.ArrayList;
import java.util.random.RandomGenerator;

public class PetrolStationMain {
    private final static RandomGenerator random = RandomGenerator.getDefault();

    @SneakyThrows
    public static void main(String[] args) {
        var petrolStation = new LockPetrolStation(1_000);

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
        threads.forEach(Thread::start);

        for (var thread : threads) {
            thread.join();
        }

        synchronized (petrolStation) {
            System.out.println("Remained volume: " + petrolStation.volume());
        }
    }
}
