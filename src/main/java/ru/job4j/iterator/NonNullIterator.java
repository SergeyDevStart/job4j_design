package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NonNullIterator implements Iterator<Integer> {

    private Integer[] data;
    private int index;

    public NonNullIterator(Integer[] data) {
        this.data = data;
    }

    private boolean isEmpty(Integer[] array) {
        return array != null;
    }

    @Override
    public boolean hasNext() {
        boolean notEmpty = isEmpty(data);
        while (notEmpty && index < data.length && data[index] == null) {
            index++;
        }
        return notEmpty && index < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

}
