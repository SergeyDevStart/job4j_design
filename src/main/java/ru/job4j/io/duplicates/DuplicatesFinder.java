package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        printDuplicate(Path.of("./"));
    }

    public static void printDuplicate(Path path) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(path, visitor);
        visitor.getMap().entrySet().stream()
                .filter(map -> map.getValue().size() > 1)
                .flatMap(map -> map.getValue().stream())
                .forEach(System.out::println);
    }
}
