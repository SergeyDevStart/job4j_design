package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count == (int) (table.length * LOAD_FACTOR)) {
            expand();
        }
        int index = indexFor(hash(Objects.hashCode(key)));
        boolean check = table[index] == null;
        if (check) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        return check;
    }

    private int hash(int hashCode) {
        return hashCode == 0 ? 0 : hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        MapEntry<K, V>[] newTable = new MapEntry[table.length * 2];
        for (var cell : table) {
            if (cell != null) {
                int newIndex = indexForExpand(hash(Objects.hashCode(cell.key)), newTable.length);
                newTable[newIndex] = cell;
            }
        }
        table = newTable;
    }

    private int indexForExpand(int hash, int newLength) {
        return hash & (newLength - 1);
    }

    private boolean checkIndex(K key, int index) {
        return table[index] != null && (Objects.hashCode(table[index].key) == Objects.hashCode(key)
                && Objects.equals(table[index].key, key));
    }

    @Override
    public V get(K key) {
        V element = null;
        int index = indexFor(hash(Objects.hashCode(key)));
        if (checkIndex(key, index)) {
            element = table[index].value;
        }
        return element;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(Objects.hashCode(key)));
        int expectedCount = count;
        if (checkIndex(key, index)) {
            table[index] = null;
            count--;
            modCount++;
        }
        return count < expectedCount;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int index = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
