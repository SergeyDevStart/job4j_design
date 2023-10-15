package ru.job4j.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws IOException {
        List<List<String>> list = new ArrayList<>();
        String delimiter = argsName.get("delimiter");
        try (var scanner = new Scanner(Path.of(argsName.get("path"))).useDelimiter(System.lineSeparator())) {
            while (scanner.hasNext()) {
                list.add(new ArrayList<>(Arrays.asList(scanner.next().split(delimiter))));
            }
        }
        List<Integer> indexes = getIndex(list.get(0), argsName.get("filter"));
        String outData = out(list, indexes, delimiter);
        if ("stdout".equals(argsName.get("out"))) {
            System.out.println(outData);
        } else {
            Path path = Path.of(argsName.get("out"));
            try (var writer = new PrintWriter(new FileWriter(path.toFile()))) {
                writer.println(outData);
            }
        }
    }

    private static List<Integer> getIndex(List<String> list, String string) {
        List<Integer> result = new ArrayList<>();
        List<String> lines = new ArrayList<>(Arrays.asList(string.split(",")));
        for (String line : lines) {
            result.add(list.indexOf(line));
        }
        return result;
    }

    private static String out(List<List<String>> data, List<Integer> indexes, String delimiter) {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        for (List<String> list : data) {
            List<String> temp = new ArrayList<>();
            for (Integer index : indexes) {
                temp.add(list.get(index));
            }
            sj.add(String.join(delimiter, temp));
            temp.clear();
        }
        return sj.toString();
    }

    private static ArgsName validation(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        if (!argsName.get("path").endsWith(".csv")) {
            throw new IllegalArgumentException("The file must have a .csv extension");
        }
        if (!"stdout".equals(argsName.get("out")) || !argsName.get("out").endsWith(".csv")) {
            throw new IllegalArgumentException("Enter 'stdout' or path to file");
        }
        return argsName;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Actual and formal argument lists differ in length");
        }
        handle(validation(args));
    }
}
