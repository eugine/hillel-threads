package ua.ithillel.hausaufgabe.hw3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private static final int HINT_LENGTH = 15;
    public static final char PLACEHOLDER_CHAR = '#';
    private final String puzzle;

    public Game(String puzzle) {
        this.puzzle = puzzle;
    }

    public GameResult play(String guess) {
        if (puzzle.equalsIgnoreCase(guess)) {
            return new GameResult(puzzle, GameStatus.WIN);
        }
        return new GameResult(getHint(guess), GameStatus.LOST);
    }

    private String getHint(String guess) {
        var sb = new StringBuilder();
        for (int i = 0; i < HINT_LENGTH; i++) {
            sb.append(resolveSymbol(puzzle, guess, i));
        }
        return sb.toString();
    }

    // same hint bug with Streams
    private String getHint2(String guess) {
        return IntStream.range(0, HINT_LENGTH)
                .mapToObj(index -> resolveSymbol(puzzle, guess, index))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private char resolveSymbol(String puzzle, String guess, int index) {
        if (index >= puzzle.length() || index >= guess.length()) {
            return PLACEHOLDER_CHAR;
        }
        var charAreSame = puzzle.charAt(index) == guess.charAt(index);
        return charAreSame ? puzzle.charAt(index) : PLACEHOLDER_CHAR;
    }
}
