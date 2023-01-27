package ua.ithillel.debug;

import ua.ithillel.calculator.Calculator;

public class DebugExample {
    public static void main(String[] args) {
        var sum4 = add(1, 3);
        var sum5 = add(2, 3);
        var sum6 = add(5, 1);
    }

    public static int add(int a, int b) {
        var calc = new Calculator();
        return calc.add(a, b);
    }
}
