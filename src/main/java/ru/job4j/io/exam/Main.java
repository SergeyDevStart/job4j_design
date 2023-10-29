package ru.job4j.io.exam;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 4) {
            throw new IllegalArgumentException("Enter 4 arguments.");
        }
        ArgsName argsName = ArgsName.of(args);
        verification(argsName);
        Predicate<Path> condition = defineSearchType(argsName);
        List<Path> paths = Search.search(Path.of(argsName.get("d")), condition);
        outToFile(paths, argsName.get("o"));
    }

    private static void outToFile(List<Path> paths, String file) {
        try (var writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            paths.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Predicate<Path> defineSearchType(ArgsName argsName) {
        Predicate<Path> condition;
        String fileName = argsName.get("n");
        String typeSearch = argsName.get("t");
        switch (typeSearch) {
            case "name" :
                condition = p -> p.toString().equals(fileName);
                break;
            case "regex" :
                condition = p -> p.toString().matches(fileName);
                break;
            case "mask" :
                String regex = fileName.replace(".", "\\.")
                        .replace("*", ".*")
                        .replace("?", ".");
                condition = p -> p.toString().matches(regex);
                break;
            default: return null;
        }
        return condition;
    }

    private static void verification(ArgsName argsName) {
        Path directory = Path.of(argsName.get("d"));
        if (!Files.exists(directory) || !Files.isDirectory(directory)) {
            throw new IllegalArgumentException("The path is not exist");
        }
        if (!argsName.get("o").matches("\\w+\\.\\w+")) {
            throw new IllegalArgumentException("Error in file name");
        }
        String searchType = argsName.get("t");
        if (!("name".equals(searchType) || "regex".equals(searchType) || "mask".equals(searchType))) {
            throw new IllegalArgumentException("Enter 'mask' or 'regex' or 'name'");
        }
        if (argsName.get("n").length() < 3) {
            throw new IllegalArgumentException("Invalid file name or mask or regex");
        }
    }
}
