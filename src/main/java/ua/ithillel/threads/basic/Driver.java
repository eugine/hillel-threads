package ua.ithillel.threads.basic;

record Person(int id, String name) {}

public class Driver {

    public static void main(String[] args) {
        int id = 23;
        String pName = "Jon";
        Person p = null;
        p = new Person(id, pName);
        //p.id()
        //p.name()

        // String pool example:
//        System.out.println(pName == "Jon");
//        System.out.println(pName == new String("Jon"));
    }
}
