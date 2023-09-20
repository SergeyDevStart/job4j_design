package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(
                     new BufferedWriter(
                             new FileWriter(target)
                     ))) {
            boolean worker = true;
            String[] lines = in.lines().toArray(String[]::new);
            for (String line : lines) {
                if (worker && (line.startsWith("500") || line.startsWith("400"))) {
                    worker = false;
                    out.printf("%s%s", line.substring(4), ";");
                } else if (!worker && (line.startsWith("200") || line.startsWith("300"))) {
                    out.printf("%s%n", line.substring(4));
                    worker = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
