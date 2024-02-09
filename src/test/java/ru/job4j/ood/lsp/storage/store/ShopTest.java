package ru.job4j.ood.lsp.storage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.model.Bread;
import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.model.Milk;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class ShopTest {
    @Test
    public void whenAdd3FoodThen2TrueAnd1False() {
        Store store = new Shop();
        LocalDate now = LocalDate.now();
        Food food1 = new Milk("Milk", now.minusDays(2), now.plusDays(7), 100);
        Food food2 = new Bread("Bread", now.minusDays(2), now.plusDays(6), 50);
        Food food3 = new Bread("Bread", now.minusDays(2), now.plusDays(2), 50);
        assertThat(store.checkDate(food1)).isFalse();
        assertThat(store.checkDate(food2)).isTrue();
        assertThat(store.checkDate(food3)).isTrue();
    }

    @Test
    public void whenAddFoodThenPriceChangeBy20Percent() {
        Store store = new Shop();
        LocalDate now = LocalDate.now();
        Food food = new Milk("Milk", now.minusDays(4), now.plusDays(1), 100);
        store.checkDate(food);
        assertThat(food.getPrice()).isEqualTo(80);
    }
}