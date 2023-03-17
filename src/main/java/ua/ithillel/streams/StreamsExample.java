package ua.ithillel.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;
import java.util.stream.*;

public class StreamsExample {

    public static final List<String> NAMES = Arrays.asList("John", "Jane", "Adam", "Eve");

    public static void main(String[] args) {
//        streamCreation();
//        numericStreams();
//        streamLaziness();
//        streamFiltering();
//        streamSorting();

    }

    private static void streamCreation() {
        Stream<String> stringStream = Stream.of("hello", "worlds");
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Stream<?> emptyStream = Stream.empty();
        Stream<String> namesStream = NAMES.stream();
    }

    private static void streamLaziness() {
        List<String> list = Arrays.asList("obc", "bcd", "cde");
        var counter = new AtomicInteger();
//        int finalCounter = 0;
        Stream<String> stream = list.stream().filter(element -> {
            counter.incrementAndGet();
//            finalCounter++;
            return element.contains("2");
        });
        System.out.println(counter.get());
    }

    private static void numericStreams() {
        IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5);
        IntStream intStream2 = IntStream.range(0, 10);
        Random random = new Random();
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
        List<String> filteredNames = NAMES.stream()
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.toList());

        System.out.println(filteredNames);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 == 1)
//                .collect(Collectors.toList());
                .toList();

//        System.out.println("odd numbers:" + oddNumbers);

        List<Integer> nameLengths = NAMES.stream()
                .map(String::length)
                .toList();

//        System.out.println("name lengths: " + nameLengths);
    }

    private static void streamSorting() {
        List<String> sortedNames = NAMES.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNames);
    }
}
