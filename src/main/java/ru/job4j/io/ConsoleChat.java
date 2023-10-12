package ru.job4j.io;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> dialogue = new ArrayList<>();
        List<String> botAnswers = readPhrases();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean check = true;
        String line = scanner.nextLine();
        while (!OUT.equals(line)) {
            dialogue.add(line);
            if (STOP.equals(line)) {
                check = false;
            } else if (CONTINUE.equals(line)) {
                check = true;
            }
            if (check) {
                String answer = botAnswers.get(random.nextInt(botAnswers.size()));
                System.out.println(answer);
                dialogue.add(answer);
            }
            line = scanner.nextLine();
        }
        dialogue.add(line);
        saveLog(dialogue);
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            reader.lines().forEach(answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> log) {
        try (var writer = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("C:\\projects\\job4j_design\\data\\chatLog.txt",
                "C:\\projects\\job4j_design\\data\\answers.txt");
        cc.run();
    }
}
