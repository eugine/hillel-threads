package ua.ithillel.streams.figure;

import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Stream;

import static ua.ithillel.streams.figure.FigureType.PENTAGON;


public class FigureStreamExample {
    public static void main(String[] args) {
        List<Figure> figures = List.of(
                new Circle(1),
                new Triangle(1, 2),
                new Squire(1),
                new Pentagon()
        );

        var area = 0.0;
        for (var figure : figures) {
            if (figure.type() != PENTAGON) {
                area += figure.area();
            }
        }
        System.out.println(area);

        var area2 = figures.stream()
                .filter(figure -> figure.type() != PENTAGON)
                .mapToDouble(figure -> figure.area())
                .sum();

        System.out.println(area2);
//        areaStream1(figures);
//        areaStream2(figures);

    }

    private static double areaStream1(List<Figure> figures) {
        return figures.stream()
                .filter(figure -> figure.type() != PENTAGON)
                .mapToDouble(figure -> figure.area())
                .sum();
    }

    private static double areaStream2(List<Figure> figures) {
        return figures.stream()
                .filter(figure -> figure.type() != PENTAGON)
                .map(Figure::area)
                .reduce(0.0, Double::sum);
    }
}
