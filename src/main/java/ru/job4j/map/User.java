package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();
        User user1 = new User("Sergey", 23, date);
        int hashCode1 = user1.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int bucket1 = hash1 & 15;
        User user2 = new User("Sergey", 23, date);
        int hashCode2 = user2.hashCode();
        int hash2 = hashCode2 ^ (hashCode1 >>> 16);
        int bucket2 = hash2 & 15;
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println("user1: " + hashCode1 + " " + hash1 + " " + bucket1);
        System.out.println("user2: " + hashCode2 + " " + hash2 + " " + bucket2);
    }
}
