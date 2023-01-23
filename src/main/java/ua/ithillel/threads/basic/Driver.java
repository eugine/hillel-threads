package ua.ithillel.threads.basic;

public class Driver {
    public record Person(int id, String name) {}

    public static void main(String[] args) {
        int id = 23;
        String pName = "Jon";
        Person p = null;
        p = new Person(id, pName);

        // String pool example:
        System.out.println(pName == "Jon");
        System.out.println(pName == new String("Jon"));
    }
}
