package ru.job4j.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Buffer {
    public static void main(String[] args) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("data/newData.txt"));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("data/output.txt", true))) {
            out.write(in.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
