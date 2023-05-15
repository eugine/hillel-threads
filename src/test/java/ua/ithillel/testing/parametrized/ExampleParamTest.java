package ua.ithillel.testing.parametrized;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExampleParamTest {

    public static int sum(int a, int b) {
        return a + b;
    }

    @Test
    void sum() {
        assertThat(sum(1, 2), equalTo(3));
    }

    @ParameterizedTest()
    @MethodSource("datasource")
    void sumParams(int a, int b, int expected) {
        assertThat(sum(a, b), equalTo(expected));
    }

    private static Stream<Arguments> datasource() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 3, 5),
                Arguments.of(100, 200, 300)
        );
    }
}
