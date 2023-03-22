package ua.ithillel.hausaufgabe.lambdas.hero;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toMap;

public class HeroCsvLoader {

    public static List<Hero> load() {
        return load("/heroes_information.csv");
    }

    public static List<Hero> load(String path) {
        try (var scanner = new Scanner(requireNonNull(HeroCsvLoader.class.getResourceAsStream(path)))) {
            var headers = parseHeaders(scanner.nextLine());
            return Stream.generate(() -> scanner.hasNext() ? scanner.nextLine() : null)
                    .takeWhile(Objects::nonNull)
                    .map(line -> line.split(";"))
                    .map(Arrays::asList)
                    .map(values -> parseHero(values, headers))
                    .toList();
        }
    }

    private static Hero parseHero(List<String> values, Map<String, Integer> headers) {
        return new Hero(
                values.get(headers.get("Name")),
                values.get(headers.get("Gender")),
                values.get(headers.get("Eye color")),
                values.get(headers.get("Race")),
                values.get(headers.get("Hair color")),
                Double.parseDouble(values.get(headers.get("Height")).replace(",", ".")),
                values.get(headers.get("Publisher")),
                values.get(headers.get("Skin color")),
                values.get(headers.get("Alignment")),
                Integer.parseInt(values.get(headers.get("Weight")))
        );
    }

    private static Map<String, Integer> parseHeaders(String headline) {
        var headers = Arrays.stream(headline.split(";")).toList();
        return IntStream.range(0, headers.size()).boxed()
                .collect(toMap(headers::get, i -> i));
    }

    public static void main(String[] args) {
        List<Hero> heroes = load();
        System.out.println(heroes.stream().limit(2).toList());
    }

}
