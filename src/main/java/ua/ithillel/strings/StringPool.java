package ua.ithillel.strings;

public class StringPool {
    public static void main(String[] args) {
        String name = "Ralf";

//        System.out.println(name == "Ralf");
//        System.out.println(name.equals("Ralf"));

        System.out.println(name == new String("Ralf"));
        System.out.println(name.equals(new String("Ralf")));

        System.out.println(name == new String("Ralf").intern());

    }
}
