package ua.ithillel.strings;

import ua.ithillel.dto.PersonRecord;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class StringExample {
    public static void main(String[] args) {
        // creation a string
        var name = "Hillel";
        var fullName = "Hillel School";

        var multilineString =
                "This is a text block\n" +
                "Containing multiple lines";

        var textBlock =
                """
                This is a text block
                Containing multiple lines
                """;

        //methods
        name.length();
        name.toLowerCase(Locale.ROOT);
        name.toUpperCase(Locale.ROOT);
        name.equalsIgnoreCase(fullName);
        name.getBytes(StandardCharsets.UTF_8);

        name.charAt(0);

        name.contains("lel");
        name.indexOf("lel");
        name.startsWith("Hil");

        name.matches(".*"); //regex - regular expressions

        String[] items = "String1,String2,String3".split(",");

//        Arrays.stream("String1,String2,String3".split(",")).count()

        name.substring(3);

        // concatenation
        var concatenation1 = name.concat("test"); // Hilleltest
        var concatenation2 = name + "test";
        var concatenation3 = name + new PersonRecord(1, "name", "year", "address"); //HillelPersonRecord[1,name,year

        System.out.println(String.format("Hello %s, test", name));
        //string pool
        // -> new StringPool();

        // Immutable & mutable String
        StringBuilder builder = new StringBuilder()
                .append(name)
                .append(" ")
                .append("something else");


    }
}
