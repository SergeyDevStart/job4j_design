package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(String.format(
                    "This key: '%s' is missing", key
            ));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        Arrays.stream(args)
                .map(str -> str.split("=", 2))
                .forEach(str -> values.put(str[0].substring(1), str[1]));
    }

    public static ArgsName of(String[] args) {
        verification(args);
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    private static void verification(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        for (String line : args) {
            if (!line.startsWith("-")) {
                throw new IllegalArgumentException(String.format(
                        "Error: This argument '%s' does not start with a '-' character", line
                ));
            }
            if (!line.contains("=")) {
                throw new IllegalArgumentException(String.format(
                        "Error: This argument '%s' does not contain an equal sign", line
                ));
            }
            if (line.indexOf("=") - line.indexOf("-") == 1) {
                throw new IllegalArgumentException(String.format(
                        "Error: This argument '%s' does not contain a key", line
                ));
            }
            if (line.indexOf("=") == line.length() - 1) {
                throw new IllegalArgumentException(String.format(
                        "Error: This argument '%s' does not contain a value", line
                ));
            }
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
