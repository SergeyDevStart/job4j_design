package ru.job4j.ood.lsp.storage.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.model.Bread;
import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.model.Milk;
import ru.job4j.ood.lsp.storage.store.Shop;
import ru.job4j.ood.lsp.storage.store.Store;
import ru.job4j.ood.lsp.storage.store.Trash;
import ru.job4j.ood.lsp.storage.store.Warehouse;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {
    private ControlService service;
    Store trash = new Trash();
    Store warehouse = new Warehouse();
    Store shop = new Shop();

    @BeforeEach
    public void init() {
        List<Store> storeList = Arrays.asList(trash, warehouse, shop);
        service = new ControlQuality(storeList);
    }

    @Test
    public void whenAddFoodThenMovingInTrash() {
        LocalDate now = LocalDate.now();
        Food food = new Milk("Milk", now, now.minusDays(2), 100);
        service.distribute(food);
        assertThat(trash.findAll()).contains(food);
    }

    @Test
    public void  whenAddFoodThenMovingInShop() {
        LocalDate now = LocalDate.now();
        Food food1 = new Bread("Bread", now.minusDays(2), now.plusDays(6), 50);
        Food food2 = new Bread("Bread", now.minusDays(6), now.plusDays(2), 50);
        Food food3 = new Bread("Bread", now.minusDays(4), now.plusDays(1), 50);
        service.distribute(food1);
        service.distribute(food2);
        service.distribute(food3);
        assertThat(shop.findAll()).contains(food1, food2, food3);
    }

    @Test
    public void whenAddFoodThenMovingInWarehouse() {
        LocalDate now = LocalDate.now();
        Food food = new Milk("Milk", now.minusDays(2), now.plusDays(7), 100);
        service.distribute(food);
        assertThat(warehouse.findAll()).contains(food);
    }
}