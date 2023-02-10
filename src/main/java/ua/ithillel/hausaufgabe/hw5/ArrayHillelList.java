package ua.ithillel.hausaufgabe.hw5;

import java.util.Objects;

public class ArrayHillelList implements HillelList {

    private String items[];

    public ArrayHillelList() {
        items = new String[0];
    }

    public ArrayHillelList(String... items) {
        this.items = new String[items.length];
        System.arraycopy(items, 0, this.items, 0, items.length);
    }

    @Override
    public void add(String item) {
        var result = new String[items.length + 1];
        if (items.length > 0) {
            System.arraycopy(items, 0, result, 0, items.length);
        }
        result[items.length] = item;
        items = result;
    }

    @Override
    public String remove(int index) {
        if (index >= items.length) {
            return null;
        }
        var result = new String[items.length - 1];
        if (index > 0) {
            System.arraycopy(items, 0, result, 0, index);
        }
        if (index < result.length) {
            System.arraycopy(items, index + 1, result, index, items.length - index - 1);
        }
        var remoted = items[index];
        items = result;
        return remoted;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        int idx = -1;
        for (int i = 0; i < items.length; i++) {
            if (Objects.equals(items[i], item)) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    @Override
    public int size() {
        return items.length;
    }

    @Override
    public String get(int index) {
        return items[index];
    }

    @Override
    public String[] getAll() {
        return items;
    }

}
