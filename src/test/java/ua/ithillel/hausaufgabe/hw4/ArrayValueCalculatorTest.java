package ua.ithillel.hausaufgabe.hw4;

import org.junit.jupiter.api.Test;

import java.util.random.RandomGenerator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayValueCalculatorTest {

    public static final RandomGenerator RANDOM_GENERATOR = RandomGenerator.getDefault();

    private final ArrayValueCalculator target = new ArrayValueCalculator();

    @Test
    void shouldSumElements() {
        var array = generateData(4, 4);

        assertThat(target.doCalc(array), equalTo(sum(array)));
    }

    @Test
    void shouldThrowExceptionForWrongArraySize() {
        assertThrows(ArraySizeException.class, () -> target.doCalc(generateData(4, 5)));
        assertThrows(ArraySizeException.class, () -> target.doCalc(generateData(5, 4)));
    }

    @Test
    void shouldThrowExceptionForNonIntValue() {
        var array = generateData(4, 4);
        array[1][1] = "crap";

        assertThrows(ArrayDataException.class, () -> target.doCalc(array));
    }


    private int sum(String[][] array) {
        return Stream.of(array)
                .flatMap(Stream::of)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String[][] generateData(int dimension1, int dimension2) {
        return IntStream.range(0, dimension1)
                .mapToObj(row -> generateRow(dimension2))
                .toArray(String[][]::new);
    }

    private String[] generateRow(int dimension) {
        return IntStream.range(0, dimension)
                .mapToObj(cell -> RANDOM_GENERATOR.nextInt(100))
                .map(String::valueOf)
                .toArray(String[]::new);
    }


}
