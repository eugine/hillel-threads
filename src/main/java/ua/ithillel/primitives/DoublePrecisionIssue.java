package ua.ithillel.primitives;

public class DoublePrecisionIssue {
    public static void main(String[] args) {
        double value = 4.01 * 4.01;

        // 16,0801

        System.out.println(value);
//        System.out.println(String.format("%.4f", value));
    }
}
