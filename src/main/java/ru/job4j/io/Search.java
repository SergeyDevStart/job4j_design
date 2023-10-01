package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        verification(args);
        Path start = Path.of(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void verification(String[] args) {
        if (args.length == 0 || args.length > 2) {
            throw new IllegalArgumentException("Use two parameters: ROOT_FOLDER FILE_EXTENSION");
        }
        if (!Files.isDirectory(Path.of(args[0]))) {
            throw new IllegalArgumentException("Such directory does not exist. Use ROOT_FOLDER.");
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException("For second parameter use this format: \".FILE_EXTENSION\"");
        }
    }
}
