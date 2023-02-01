package ua.ithillel.hausaufgabe.hw3;

public class Game {
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
        for (int i = 0; i < 15; i++) {
            sb.append(resolveSymbol(puzzle, guess, i));
        }
        return sb.toString();
    }

/*
// same hint with Streams
    private String getHint(String guess) {
        return IntStream.range(0, 15)
                .mapToObj(index -> resolveSymbol(puzzle, guess, index))
                .collect(joining());
    }
 */

    private String resolveSymbol(String puzzle, String guess, int index) {
        if (index < puzzle.length() && index < guess.length() && puzzle.charAt(index) == guess.charAt(index)) {
            return String.valueOf(puzzle.charAt(index));
        }
        return "#";
    }
}
