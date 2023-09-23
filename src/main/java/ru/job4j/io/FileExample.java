package ru.job4j.io;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/main/java/ru/job4j/io/files");
        directory.mkdir();
        File file = new File("src/main/java/ru/job4j/io/files/file.txt");
        file.createNewFile();
    }
}
