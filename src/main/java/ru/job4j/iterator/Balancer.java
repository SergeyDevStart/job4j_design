package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        if (nodes != null && !nodes.isEmpty()) {
            for (int index = 0; source.hasNext();) {
                if (index < nodes.size()) {
                    nodes.get(index++).add(source.next());
                } else {
                    index = 0;
                }
            }
        }
    }
}
