package ua.ithillel.primitives;

public class StringPool {
    public static void main(String[] args) {
        var name = "Ralf";

        System.out.println(name == "Ralf");
        System.out.println(name == new String("Ralf"));

    }
}
