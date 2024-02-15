package ru.job4j.ood.isp.violation.system;

public interface Action {
    boolean create(String name);

    boolean delete(String name);

    boolean replace(String name);

    String findByName(String name);

    String findById();
}
