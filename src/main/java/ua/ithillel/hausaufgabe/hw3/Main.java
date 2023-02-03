package ua.ithillel.hausaufgabe.hw3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {

    private final static String[] WORDS = loadWorlds();

    private static String[] loadWorlds() {
        try {
            return Files.readAllLines(Paths.get(Main.class.getResource("/hw3-words.db").toURI()))
                    .toArray(new String[]{});
        } catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }


    public static void main(String[] args) {
        var puzzle = WORDS[RandomGenerator.getDefault().nextInt(WORDS.length)];
        System.out.println("Puzzle world - " + puzzle);
        var game = new Game(puzzle);

        var scanner = new Scanner(System.in);
        while (true) {
            var result = game.play(scanner.next());
            if (result.status() == RoundStatus.WIN) {
                System.out.println("You win the game!");
                break;
            } else {
                System.out.println("Try again, your result: " + result.hint());
            }
        }
    }
}
