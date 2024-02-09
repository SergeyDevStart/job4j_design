package ru.job4j.ood.lsp.storage.store;

import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.service.ExpirationDateChecker;

public class Shop extends AbstractStore {
    ExpirationDateChecker dataChecker = new ExpirationDateChecker();

    @Override
    public boolean checkDate(Food food) {
        boolean result = false;
        double usedPercent = dataChecker.calculatePercentageOf(food);
        if (usedPercent >= 25 && usedPercent <= 75) {
            result = true;
        } else if (usedPercent > 75 && usedPercent < 100) {
            addDiscount(food);
            result = true;
        }
        return result;
    }

    private void addDiscount(Food food) {
        food.setDiscount(20);
        food.setPrice(food.getPrice() * ((100 - food.getDiscount()) / 100));
    }
}
