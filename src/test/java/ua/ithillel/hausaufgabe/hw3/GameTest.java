package ua.ithillel.hausaufgabe.hw3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ua.ithillel.hausaufgabe.hw3.RoundStatus.LOST;
import static ua.ithillel.hausaufgabe.hw3.RoundStatus.WIN;

class GameTest {

    @Test
    void shouldWinGame() {
        var game = new Game("puzzle");

        var result = game.play("puzzle");

        assertThat(result, equalTo(new RoundResult(WIN, "puzzle")));
    }

    @Test
    void shouldNotMatchThePuzzle() {
        var game = new Game("puzzle");

        var result = game.play("pizza");

        assertThat(result, equalTo(new RoundResult(LOST, "p#zz###########")));
    }

    @ParameterizedTest
    @MethodSource("datasource")
    void shouldAssertGameResult(String puzzle, String guess, RoundResult expectedResult) {
        var game = new Game(puzzle);

        var result = game.play(guess);

        assertThat(result, equalTo(expectedResult));
    }

    private static Stream<Arguments> datasource() {
        return Stream.of(
                Arguments.of("puzzle", "puzzle", new RoundResult(WIN, "puzzle")),
                Arguments.of("puzzle", "pizza", new RoundResult(LOST, "p#zz###########")),
                Arguments.of("apple", "apricot", new RoundResult(LOST, "ap#############"))
        );
    }

}
