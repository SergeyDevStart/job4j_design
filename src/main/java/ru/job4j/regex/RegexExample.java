package ru.job4j.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Hello");
        String text = "Hello";
        Matcher matcher = pattern.matcher(text);
        boolean result = matcher.matches();
        System.out.println(result);
    }
}
