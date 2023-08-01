package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.nextIndex() == index) {
                iterator.add(value);
                break;
            }
            iterator.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.previousIndex() == index) {
                iterator.add(value);
                break;
            }
            iterator.next();
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        if (list.size() != 0) {
            ListIterator<T> iterator = list.listIterator();
            while (iterator.hasNext()) {
                T element = iterator.next();
                if (filter.test(element)) {
                    iterator.remove();
                    break;
                }
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        if (list.size() != 0) {
            ListIterator<T> iterator = list.listIterator();
            while (iterator.hasNext()) {
                T element = iterator.next();
                if (filter.test(element)) {
                    iterator.set(value);
                    break;
                }
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        if (list.size() != 0 && elements.size() != 0) {
            for (T element : elements) {
                removeIf(list, p -> Objects.equals(p, element));
            }
        }
    }
}
