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

    private static Stream<Arguments> datasource() {
        return Stream.of(
                Arguments.of("puzzle", "puzzle", new RoundResult("puzzle", WIN)),
                Arguments.of("puzzle", "pizza", new RoundResult("p#zz###########", LOST)),
                Arguments.of("apple", "apricot", new RoundResult("ap#############", LOST))
        );
    }

    @Test
    void shouldWinGame() {
        var game = new Game("puzzle");

        var result = game.play("puzzle");

        assertThat(result, equalTo(new RoundResult("puzzle", WIN)));
    }

    @Test
    void shouldNotMatchThePuzzle() {
        var game = new Game("puzzle");

        var result = game.play("pizza");

        assertThat(result, equalTo(new RoundResult("p#zz###########", LOST)));
    }

    @ParameterizedTest
    @MethodSource("datasource")
    void shouldAssertGameResult(String puzzle, String guess, RoundResult expectedResult) {
        var game = new Game(puzzle);

        var result = game.play(guess);

        assertThat(result, equalTo(expectedResult));
    }

}
