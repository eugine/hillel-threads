package ua.ithillel.collections.iterator;

import java.util.Iterator;

public class MyStringIterator implements Iterator<String> {

    private final String[] items;
    private int position = 0;

    public MyStringIterator(String value) {
        items = new String[value.length()];
        for (int i = 0; i < items.length; i++) {
            items[i] = String.valueOf(value.charAt(i));
        }
    }

    @Override
    public boolean hasNext() {
        return position < items.length;
    }

    @Override
    public String next() {
        if (hasNext()) {
            return items[position++];
        }
        throw new IndexOutOfBoundsException();
    }
}
