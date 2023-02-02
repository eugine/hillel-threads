package ua.ithillel.hausaufgabe.hw3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ua.ithillel.hausaufgabe.hw3.GameStatus.LOST;
import static ua.ithillel.hausaufgabe.hw3.GameStatus.WIN;

class GameTest {

    private static Stream<Arguments> datasource() {
        return Stream.of(
                Arguments.of("puzzle", "puzzle", new GameResult("puzzle", WIN)),
                Arguments.of("puzzle", "pizza", new GameResult("p#zz###########", LOST)),
                Arguments.of("apple", "apricot", new GameResult("ap#############", LOST))
        );
    }

    @Test
    void shouldWinGame() {
        var game = new Game("puzzle");

        var result = game.play("puzzle");

        assertThat(result, equalTo(new GameResult("puzzle", WIN)));
    }

    @Test
    void shouldNotMatchThePuzzle() {
        var game = new Game("puzzle");

        var result = game.play("pizza");

        assertThat(result, equalTo(new GameResult("p#zz###########", LOST)));
    }

    @ParameterizedTest
    @MethodSource("datasource")
    void shouldAssertGameResult(String puzzle, String guess, GameResult expectedResult) {
        var game = new Game(puzzle);

        var result = game.play(guess);

        assertThat(result, equalTo(expectedResult));
    }

}
