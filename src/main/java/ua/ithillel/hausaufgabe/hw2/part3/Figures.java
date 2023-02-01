package ua.ithillel.hausaufgabe.hw2.part3;

public class Figures {
    public static double area(Figure figure) {
        return figure.area();
//        return switch (figure) {
////            case Circle c -> c.getRadius() * c.getRadius() * Math.PI;
////            case Triangle t -> c.getRadius() * c.getRadius() * Math.PI;
//            default -> throw new IllegalStateException("Unsupported figure type: " + figure);
//        };
    }
}
