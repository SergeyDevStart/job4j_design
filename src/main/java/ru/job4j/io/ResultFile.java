package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultFile {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("data/result.txt")
                ))) {
            for (int index = 2; index < 10; index++) {
                String str = String.format("1 * %d = %d", index, index);
                out.println(str);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
