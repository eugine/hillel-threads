package ua.ithillel.hausaufgabe.hw4;

public class ArrayValueCalculator {

    public static final int DIMENSION = 4;

    public int doCalc(String[][] data) {
        if (data.length != DIMENSION) {
            throw new ArraySizeException("Array must have dimension 4x4");
        }
        int accumulator = 0;
        for (String[] row : data) {
            accumulator += doCalc(row);
        }
        return accumulator;
    }

    private int doCalc(String[] row) {
        int accumulator = 0;
        if (row.length != DIMENSION) {
            throw new ArraySizeException("Array must have dimension 4x4");
        }
        for (String element : row) {
            try {
                accumulator += Integer.parseInt(element);
            } catch (NumberFormatException e) {
                throw new ArrayDataException(e);
            }
        }
        return accumulator;
    }
}
