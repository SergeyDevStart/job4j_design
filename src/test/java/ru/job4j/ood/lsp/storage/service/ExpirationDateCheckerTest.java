package ru.job4j.ood.lsp.storage.service;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.model.Milk;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class ExpirationDateCheckerTest {
    @Test
    public void whenExpiredThen100() {
        DateChecker checker = new ExpirationDateChecker();
        LocalDate now = LocalDate.now();
        LocalDate expired = now.minusDays(1);
        Food food = new Milk("Milk", now, expired, 100);
        double result = checker.calculatePercentageOf(food);
        assertThat(result).isEqualTo(100);
    }

    @Test
    public void whenNotExpiredThen50() {
        DateChecker checker = new ExpirationDateChecker();
        LocalDate created = LocalDate.now().minusDays(2);
        LocalDate expired = LocalDate.now().plusDays(2);
        Food food = new Milk("Milk", created, expired, 100);
        double result = checker.calculatePercentageOf(food);
        assertThat(result).isEqualTo(50);
    }

    @Test
    public void whenNotExpiredThen75() {
        DateChecker checker = new ExpirationDateChecker();
        LocalDate created = LocalDate.now().minusDays(2);
        LocalDate expired = LocalDate.now().plusDays(6);
        Food food = new Milk("Milk", created, expired, 100);
        double result = checker.calculatePercentageOf(food);
        assertThat(result).isEqualTo(25);
    }
}