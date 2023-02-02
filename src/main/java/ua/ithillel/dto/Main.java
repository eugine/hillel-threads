package ua.ithillel.dto;

public class Main {
    public static void main(String[] args) {

        test();

        //...........
        System.gc();
        //....


    }

    public static void test() {
        ///.....

        var person = new PersonRecord(1, "year", "name", "address");
        var person2 = new PersonRecord(1, "year", "name", "address");

        ///...
    }
}
