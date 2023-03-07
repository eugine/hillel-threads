package ua.ithillel.generics;

import java.util.List;

public class UnknownWildcardsExample {
    public static void processElements(List<?> elements){
        for(Object o : elements){
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        List<Integer> value = List.of(1, 2, 3);
        List<String> sValue = List.of("1", "2");

        processElements(value);
        processElements(sValue);
    }
}
