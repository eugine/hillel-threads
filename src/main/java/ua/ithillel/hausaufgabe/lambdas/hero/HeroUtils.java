package ua.ithillel.hausaufgabe.lambdas.hero;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;
import static ua.ithillel.hausaufgabe.lambdas.hero.HeroCsvLoader.load;

public class HeroUtils {

    public static double averageHeight(List<Hero> heroes) {
        return heroes.stream()
                .filter(hero -> hero.height() > 0)
                .mapToDouble(Hero::height)
                .average()
                .orElseThrow();
    }

    public static Hero findTheTallest(List<Hero> heroes) {
        return heroes.stream()
                .max(comparing(Hero::height))
                .orElseThrow();
    }

    public static Hero findTheHeaviest(List<Hero> heroes) {
        return heroes.stream()
                .max(comparing(Hero::weight))
                .orElseThrow();
    }

    public static Map<String, List<Hero>> groupByPublisher(List<Hero> heroes) {
        return groupBy(heroes, Hero::publisher);
    }

    public static Map<String, List<Hero>> groupByHairColor(List<Hero> heroes) {
        return groupBy(heroes, Hero::hairColor);
    }

    public static Map<String, List<Hero>> groupByEyeColor(List<Hero> heroes) {
        return groupBy(heroes, Hero::eyeColor);
    }

    public static Map<String, List<Hero>> groupByGender(List<Hero> heroes) {
        return groupBy(heroes, Hero::gender);
    }

    private static Map<String, List<Hero>> groupBy(List<Hero> heroes, Function<Hero, String> classifier) {
        return heroes.stream().collect(groupingBy(classifier));
    }

    public static Map<String, Integer> countByPublisher(List<Hero> heroes){
        return countBy(groupByPublisher(heroes));
    }

    public static Map<String, Integer> countByHairColor(List<Hero> heroes) {
        return countBy(groupByHairColor(heroes));
    }

    public static Map<String, Integer> countByEyeColor(List<Hero> heroes) {
        return countBy(groupByEyeColor(heroes));
    }

    public static Map<String, Integer> countByGender(List<Hero> heroes) {
        return countBy(groupByGender(heroes));
    }

    private static Map<String, Integer> countBy(Map<String, List<Hero>> heroes) {
        return heroes.entrySet().stream()
                .collect(toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
    }

    public static String findMostPopularEyeColor(List<Hero> heroes) {
        return countByEyeColor(heroes).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
    }

    public static List<String> findMostPopularPublishers(List<Hero> heroes, int limit) {
        return findMostPopular(countByPublisher(heroes), limit);
    }

    public static List<String> findMostPopularHairColors(List<Hero> heroes, int limit) {
        var grouped = countByHairColor(heroes).entrySet().stream()
                .filter(entry -> entry.getKey().length() > 1)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
        return findMostPopular(grouped, limit);
    }

    private static List<String> findMostPopular(Map<String, Integer> heroes, int limit) {
        return heroes.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }


    public static void main(String[] args) {
        var heroes = load();

        System.out.println("average height: " + averageHeight(heroes));
        System.out.println("tallest: " + findTheTallest(heroes).name());
        System.out.println("heaviest: " + findTheHeaviest(heroes).name());

        System.out.println("gender: " + countByGender(heroes));

        System.out.println("most popular publisher: " + findMostPopularPublishers(heroes, 5));
        System.out.println("most popular hair color: " + findMostPopularHairColors(heroes, 3));
        System.out.println("most popular eye color: " + findMostPopularEyeColor(heroes));
    }
}
