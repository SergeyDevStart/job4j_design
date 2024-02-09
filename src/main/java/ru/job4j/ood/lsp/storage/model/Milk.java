package ru.job4j.ood.lsp.storage.model;

import java.time.LocalDate;

public class Milk extends Food {
    public Milk(String name, LocalDate expiryDate, LocalDate createDate, double price) {
        super(name, expiryDate, createDate, price);
    }
}
