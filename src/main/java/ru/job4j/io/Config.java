package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
            in.lines()
                    .filter(line -> !line.startsWith("#") && !line.isEmpty())
                    .map(line -> line.split("=", 2))
                    .filter(this::check)
                    .forEach(arr -> values.put(arr[0], arr[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean check(String[] arr) {
        if (arr.length != 2 || arr[0].isBlank() || arr[1].isBlank()) {
            throw new IllegalArgumentException("Line contains an invalid template");
        }
        return true;
    }

    public String value(String key) {
        if (!values.containsKey(key)) {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        }
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
    }
}
