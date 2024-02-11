package ru.job4j.ood.lsp.parking.storage;

import ru.job4j.ood.lsp.parking.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public abstract class Park implements ParkSystem {
    private List<Vehicle> store = new ArrayList<>();
    private final int size;
    private int countFreePlaces;

    public Park(int size) {
        this.size = size;
        this.countFreePlaces = size;
    }

    public abstract boolean checkSizeVehicle(Vehicle vehicle);

    @Override
    public List<Vehicle> findAll() {
        return store;
    }

    @Override
    public int getFreePlaces() {
        return countFreePlaces;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public Vehicle getVehicle(int id) {
        return null;
    }
}
