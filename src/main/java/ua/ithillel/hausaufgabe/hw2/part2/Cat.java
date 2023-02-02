package ua.ithillel.hausaufgabe.hw2.part2;

public class Cat extends Animal {

    private final int MAX_RUN_DISTANCE = 100;

    private final int maxRunDistance;

    public Cat(String name, int maxRunDistance) {
        super(name);
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public void run(int distance) {
//        if (distance < 500) {
//        if (distance < MAX_RUN_DISTANCE) {
        if (distance < maxRunDistance) {
            System.out.println("Cat runs " + distance + "m");
//            System.out.println(String.format("Cat runs %s m", distance));
//            System.out.printf("Cat runs %s m%n", distance);
        } else {
            System.out.println("Cat can not run " + distance + "m");
        }
    }


}
