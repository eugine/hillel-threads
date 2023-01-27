package ua.ithillel.hausaufgabe.hw2.part3;

public class Main {

    public static void main(String[] args) {
        var figures = new Figure[] {
                new Circle(10),
                new Circle(20)
        };

        double accumulator = 0;
        for (var figure : figures) {
            accumulator += figure.area();
        }
        System.out.println(accumulator);
    }
}
