package ru.job4j.ood.lsp.storage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.model.Bread;
import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.model.Milk;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {
    @Test
    public void whenAdd4FoodThen2TrueAnd2False() {
        Store store = new Warehouse();
        LocalDate now = LocalDate.now();
        Food food1 = new Milk("Milk", now, now.plusDays(10), 100);
        Food food2 = new Milk("Milk", now.minusDays(2), now.plusDays(7), 100);
        Food food3 = new Bread("Bread", now.minusDays(2), now.plusDays(6), 50);
        Food food4 = new Bread("Bread", now.minusDays(2), now.plusDays(2), 50);
        assertThat(store.checkDate(food1)).isTrue();
        assertThat(store.checkDate(food2)).isTrue();
        assertThat(store.checkDate(food3)).isFalse();
        assertThat(store.checkDate(food4)).isFalse();
    }
}