package ru.job4j.ood.lsp.storage.store;

import ru.job4j.ood.lsp.storage.model.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private final List<Food> store = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (checkDate(food)) {
            store.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public List<Food> findAll() {
        return store;
    }

    @Override
    public abstract boolean checkDate(Food food);
}
