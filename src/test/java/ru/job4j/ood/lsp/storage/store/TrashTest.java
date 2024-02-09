package ru.job4j.ood.lsp.storage.store;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.model.Milk;

import java.time.LocalDate;

class TrashTest {
    @Test
    public void whenExpiredThenTrue() {
        LocalDate now = LocalDate.now();
        LocalDate earlier = now.minusDays(1);
        Food food = new Milk("Milk", now, earlier, 100);
        Store store = new Trash();
        assertThat(store.checkDate(food)).isTrue();
    }

    @Test
    public void whenNotExpiredThenFalse() {
        LocalDate now = LocalDate.now();
        LocalDate later = now.plusDays(1);
        Food food = new Milk("Milk", now, later, 100);
        Store store = new Trash();
        assertThat(store.checkDate(food)).isFalse();
    }
}