package ua.ithillel.streams;

import ua.ithillel.threads.advanced.counters.SimpleCounter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;
import java.util.stream.*;

public class StreamsIntermediateOperationsExample {

    public static final List<String> NAMES = Arrays.asList("John", "Jane", "Adam", "Eve");
    private static final Random random = new Random();

    public static void main(String[] args) {
//        streamCreation();
//        numericStreams();
        streamLaziness();
//        streamFiltering();
//        streamSorting();
//        infiniteStream();
//        streamMapping();
//        streamFlatMap();
    }

    private static void infiniteStream() {
        IntStream.range(0, 100)
                .skip(10)
                .limit(5)
                .forEach(value -> System.out.println(value));
    }

    private static void streamCreation() {
        Stream<String> stringStream = Stream.of("hello", "worlds");
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        Stream<?> emptyStream = Stream.empty();
        Stream<String> namesStream = NAMES.stream();
    }

    private static void streamLaziness() {
        var counter = new SimpleCounter();
        NAMES.stream()
                .filter(element -> {
                    counter.increment();
                    return element.startsWith("J");
                })
                .count();
        System.out.println(counter.getValue());
    }

    private static void numericStreams() {
        IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5);
        IntStream intStream2 = IntStream.range(0, 10);
        IntStream intStream3 = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return random.nextInt();
            }
        });

        LongStream longStream = LongStream.of(1, 2, 3, 4);
        DoubleStream doubleStream1 = DoubleStream.of(1.0, 2.0, 3.0);
    }

    private static void streamFiltering() {
        System.out.println(NAMES);
        List<String> filteredNames = NAMES.stream()
                .filter(name -> name.startsWith("J") || name.startsWith("E"))
                .filter(name -> name.length() == 3)
                .collect(Collectors.toList());
//        System.out.println(filteredNames);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 == 1)
                .toList();
//        System.out.println("odd numbers:" + oddNumbers);

        List<Integer> nameLengths = NAMES.stream()
                .filter(name -> name.startsWith("J"))
                .map(name -> name.length())
                .filter(length -> length > 2)
                .toList();
        System.out.println("name lengths: " + nameLengths);
    }

    private static void streamSorting() {
        List<String> sortedNames = NAMES.stream()
                .sorted()
                .filter(name -> name.length() == 4)
                .toList();

        System.out.println(sortedNames);
    }

    private static void streamMapping() {
        var lengths = NAMES.stream()
                .map(s -> s.length())
                .toList();
        System.out.println(lengths);
    }

    private static void streamFlatMap() {
        List<List<String>> namesOfNames = List.of(NAMES, List.of("Test1", "Test2"));

        namesOfNames.stream()
                .flatMap(list -> list.stream())
                .forEach(name -> System.out.println(name));
//        System.out.println(nammesOfNames);
    }
}
