package ru.job4j.ood.lsp.storage.store;

import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.service.ExpirationDateChecker;

public class Trash extends AbstractStore {
    ExpirationDateChecker dataChecker = new ExpirationDateChecker();

    @Override
    public boolean checkDate(Food food) {
        return dataChecker.calculatePercentageOf(food) == 100;
    }
}
