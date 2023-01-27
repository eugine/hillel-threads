package ua.ithillel.hausaufgabe.hw2.part2;

// Animal, not Animals
public abstract class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void run(int distance);
//    public abstract void swim(int distance);
}
