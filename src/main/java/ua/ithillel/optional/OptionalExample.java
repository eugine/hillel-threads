package ua.ithillel.optional;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalExample {

    public static void main(String[] args) {
        creation();
        simpleUsage("Hillel");
        operations("Hillel");
        goodUsage("Hillel");

        termination("Hillel");

        stream("Hillel");
    }


    public static void creation() {
        Optional.ofNullable("null_or_not_null");
        Optional.of("no_null");
        Optional.empty();
    }

    public static void simpleUsage(String value) {
        var empty = Optional.empty();

        empty.get();

        empty.isPresent();
        empty.isEmpty();
    }

    public static void operations(String value) {
        var optionalValue = Optional.ofNullable(value);

        optionalValue
                .map(v -> v.length())
                .filter(length -> length > 2)
                .get();

        Optional<Optional<String>> optionalOfOptionalValue = optionalValue.map(v -> Optional.of(v));
        //fm
    }

    public static void goodUsage(String value) {
        Optional<String> optionalValue = Optional.ofNullable(value);

        var length1 = optionalValue
                .map(String::length)
                .orElse(0);

        var length2 = optionalValue
                .map(String::length)
                .orElseGet(() -> 0);

        optionalValue.orElseThrow();
        optionalValue.orElseThrow(() -> new RuntimeException("exception"));
    }

    public static void termination(String value) {
        var optionalValue = Optional.ofNullable(value);

//        optionalValue.ifPresent();
//        optionalValue.ifPresentOrElse();
    }

    public static void stream(String value) {
        var optionalValue = Optional.ofNullable(value);

        Stream<String> stream = optionalValue.stream();
        stream.count();
    }
}
