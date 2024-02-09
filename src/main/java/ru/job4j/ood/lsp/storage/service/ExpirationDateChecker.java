package ru.job4j.ood.lsp.storage.service;

import ru.job4j.ood.lsp.storage.model.Food;

import java.time.LocalDate;
import static  java.time.temporal.ChronoUnit.DAYS;

public class ExpirationDateChecker implements DateChecker {
    /**
     * Метод проверяет на сколько израсходован срок годности продукта
     * @return значение израсходованности в процентах
     */
    @Override
    public double calculatePercentageOf(Food food) {
        double percent = 100;
        LocalDate now = LocalDate.now();
        LocalDate createDate = food.getCreateDate();
        LocalDate expiryDate = food.getExpiryDate();
        if (DAYS.between(now, expiryDate) > 0) {
            double dayAmount = DAYS.between(createDate, expiryDate);
            double dayUsed = DAYS.between(createDate, now);
            percent = Math.round((dayUsed / dayAmount) * 100);
        }
        return percent;
    }
}
