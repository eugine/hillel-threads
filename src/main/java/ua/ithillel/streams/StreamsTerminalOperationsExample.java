package ua.ithillel.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class StreamsTerminalOperationsExample {
    public static final List<String> NAMES = Arrays.asList("John", "Jane", "Adam", "Eve");

    public static void main(String[] args) {
//        streamCollect();
//        streamFind();

        var length = NAMES.stream()
                .filter(name -> name.startsWith("X"))
                .map(name -> name.length())
                .reduce(0, (length1, length2) -> length1 + length2);
        System.out.println(length);

    }

    private static void streamCollect() {
        var result1 = NAMES.stream()
                .toList();
//        System.out.println(result1);

        var result2 = NAMES.stream()
                .filter(name -> name.startsWith("J"))
                .distinct()
                .collect(Collectors.toList());
//        System.out.println(result2);

        var result3 = NAMES.stream()
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.toSet());
//        System.out.println(result3);

        var result4 = NAMES.stream()
                .filter(name -> name.startsWith("J"))
                .map(name -> "[" + name + "]")
                .collect(Collectors.joining(", ", "Result: ", "!"));
//        System.out.println(result4);

        var result5 = NAMES.stream()
//                .filter(name -> !name.startsWith("J"))
                .collect(Collectors.groupingBy(name -> name.substring(0, 1)));
//        System.out.println(result5);
    }

    private static void streamFind() {

        Optional<String> result1 = NAMES.stream()
                .filter(name -> name.startsWith("X"))
                .findFirst();

        System.out.println(result1);

        var maybeValue = Optional.ofNullable("something");
        System.out.println(maybeValue.orElseThrow());

        Optional<String> result2 = NAMES.stream()
                .filter(name -> false)
                .findAny();
        System.out.println(result2);

    }
}
