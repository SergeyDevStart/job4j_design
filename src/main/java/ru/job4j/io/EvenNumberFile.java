package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data/even.txt")) {
            StringBuilder builder = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                builder.append((char) read);
            }
            String[] lines = builder.toString().split(System.lineSeparator());
            for (String str : lines) {
                if (Integer.parseInt(str) % 2 == 0) {
                    System.out.println(str);
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
