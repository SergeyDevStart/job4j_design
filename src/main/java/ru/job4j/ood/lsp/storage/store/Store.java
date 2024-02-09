package ru.job4j.ood.lsp.storage.store;

import ru.job4j.ood.lsp.storage.model.Food;

import java.util.List;

public interface Store {
    boolean add(Food food);

    List<Food> findAll();

    boolean checkDate(Food food);
}
