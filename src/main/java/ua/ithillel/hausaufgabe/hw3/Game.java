package ua.ithillel.hausaufgabe.hw3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private final String puzzle;

    public Game(String puzzle) {
        this.puzzle = puzzle;
    }

    public GameResult play(String guess) {
        if (puzzle.equalsIgnoreCase(guess)) {
            return new GameResult(puzzle, GameStatus.WIN);
        }
        var hint = IntStream.range(0, 15)
                .mapToObj(index -> resolveSymbol(puzzle, guess, index))
                .collect(Collectors.joining());

        return new GameResult(hint, GameStatus.LOST);
    }

    private String resolveSymbol(String puzzle, String guess, int index) {
        if (index < puzzle.length() && index < guess.length()
                && puzzle.charAt(index) == guess.charAt(index)) {
            return String.valueOf(puzzle.charAt(index));
        }
        return "#";
    }
}
