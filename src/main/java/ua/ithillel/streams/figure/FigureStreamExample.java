package ua.ithillel.streams.figure;

import java.util.List;


public class FigureStreamExample {
    public static void main(String[] args) {
        var figures = List.of(
                new Circle(1),
                new Triangle(1, 2),
                new Squire(1),
                new Pentagon()
        );

        var totalArea = 0;
        for (var figure : figures) {
            if (figure.type() != FigureType.PENTAGON) {
                totalArea += figure.area();
            }
        }
        System.out.println(totalArea);
    }
}
