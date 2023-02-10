package ua.ithillel.collections.iterator;

import java.util.Iterator;

public class MyString implements Iterable<String> {

    private final String value;

    public MyString(String value) {
        this.value = value;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyStringIterator(value);
    }

    public static void main(String[] args) {
        MyString letters = new MyString("something");

        var iter1 = letters.iterator();
        iter1.next();
        iter1.next();

        var iter2 = letters.iterator();


        System.out.println("iter1: " + iter1.next());
        System.out.println("iter2: " + iter2.next());

    }


}
