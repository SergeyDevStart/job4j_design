package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        boolean valid = nodes != null && !nodes.isEmpty();
        for (int index = 0; source.hasNext();) {
            if (valid && index < nodes.size()) {
                nodes.get(index++).add(source.next());
            } else if (valid && index == nodes.size()) {
                index = 0;
            }
        }
    }
}
