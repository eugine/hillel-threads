package ua.ithillel.hausaufgabe.hw2.part3;

public class Main {

    public static void main(String[] args) {
        Figure[] figures = new Figure[] {
                new Circle(10),
                new Circle(20),
        };

        double sum = 0;
        for (var figure : figures) {
            sum += figure.area();
        }
        System.out.println(sum);

    }
}
