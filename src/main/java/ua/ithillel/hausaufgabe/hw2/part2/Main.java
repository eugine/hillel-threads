package ua.ithillel.hausaufgabe.hw2.part2;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Bobik");
        Cat cat = new Cat("Mursik", 100);

        var swimmer = new Swim[]{
                dog
        };

//        dog.run();
//        swimmer[0].swim();

        ((Dog) swimmer[0]).run(10);

//        dog.run();
//        dog.swim();

//        cat.swim();
    }
}
