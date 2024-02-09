package ru.job4j.ood.lsp.storage.service;

import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.store.Store;

import java.util.List;

public class ControlQuality implements ControlService {
    private final List<Store> storeList;

    public ControlQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    @Override
    public void distribute(Food food) {
        for (Store store : storeList) {
            store.add(food);
        }
    }
}
