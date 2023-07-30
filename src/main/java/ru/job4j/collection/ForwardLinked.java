package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class ForwardLinked<T> implements Iterable<T> {
    private int size = 0;
    private int modCount = 0;
    private Node<T> head;

    public void add(T item) {
        Node<T> newNode = new Node<>(item, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        size++;
        modCount++;
    }

    public void addFirst(T item) {
        head = new Node<T>(item, head);
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> tempNode = head;
        int count = 0;
        while (count != index) {
            tempNode = tempNode.next;
            count++;
        }
        return tempNode.item;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> deletNode = head;
        T deletedItem = head.item;
        head = deletNode.next;
        deletNode.item = null;
        deletNode.next = null;
        deletNode = null;
        size--;
        modCount++;
        return deletedItem;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> cursor = head;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> tempNode = cursor;
                cursor = cursor.next;
                return tempNode.item;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
