package ru.job4j.ood.dip.violation.parking;

import java.util.HashMap;
import java.util.Map;

public class ParkingManager {
    /**
     * Этот пример демонстрирует нарушение DIP.
     * Менеджер зависит от реализации хранилища, а не от абстракции.
     * Решением будет выделение абстракции для хранилища и её реализации другим классом.
     */
    private Map<Integer, Auto> store = new HashMap<>();

    public ParkingManager(Map<Integer, Auto> store) {
        this.store = store;
    }

    public boolean addToParking(Auto auto) {
        boolean result = store.containsKey(auto.getId());
        if (!result) {
            store.put(auto.getId(), auto);
        }
        return  result;
    }
}
