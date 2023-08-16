package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator<T> implements Iterator<T> {
    private final List<T> data;
    private int cursor;
    private final boolean valid;

    public CyclicIterator(List<T> data) {
        this.data = data;
        this.valid = data != null && !data.isEmpty();
    }

    @Override
    public boolean hasNext() {
        if (valid && cursor == data.size()) {
            cursor = 0;
        }
        return valid;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data.get(cursor++);
    }
}
