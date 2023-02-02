package ua.ithillel.hausaufgabe.hw5;

import java.util.Arrays;
import java.util.Objects;

public class ArrayHillelGenericsList<T> implements HillelGenericsList<T> {

    private T[] items;

    public ArrayHillelGenericsList() {
        items = (T[]) new Object[0];
    }

    public ArrayHillelGenericsList(T... items) {
        this.items = (T[]) new Object[items.length];
        System.arraycopy(items, 0, this.items, 0, items.length);
    }

    @Override
    public void add(T item) {
        var result = (T[]) new Object[items.length + 1];
        if (items.length > 0) {
            System.arraycopy(items, 0, result, 0, items.length);
        }
        result[items.length] = item;
        items = result;
    }

    @Override
    public T remove(int index) {
        if (index >= items.length) {
            return null;
        }
        var result = (T[]) new Object[items.length - 1];
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
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(T item) {
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
    public T get(int index) {
        return items[index];
    }

    @Override
    public Object[] toArray() {
        return items;
    }

    @Override
    public T[] toArray(T[] type) {
        return (T[]) Arrays.copyOf(items, items.length, type.getClass());
    }

}
