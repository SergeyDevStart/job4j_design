package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/result.txt")) {
            for (int index = 2; index < 10; index++) {
                String str = String.format("1 * %d = %d", index, index);
                out.write(str.getBytes());
                out.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
