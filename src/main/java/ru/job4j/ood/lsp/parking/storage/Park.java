package ru.job4j.ood.lsp.parking.storage;

import ru.job4j.ood.lsp.parking.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public abstract class Park implements ParkSystem {
    private final List<Vehicle> store = new ArrayList<>();
    private final int size;
    protected int countFreePlaces;

    public Park(int size) {
        this.size = size;
        this.countFreePlaces = size;
    }

    protected abstract int resize(Vehicle vehicle);

    @Override
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
        boolean result = false;
        if (size > 0  && checkSizeVehicle(vehicle) && !store.contains(vehicle)) {
            store.add(vehicle);
            result = true;
            countFreePlaces = countFreePlaces - resize(vehicle);
        }
        return result;
    }

    /**
     * @param id vehicle
     * @param size vehicle
     */
    @Override
    public Vehicle getVehicle(int id, int size) {
        Vehicle result = null;
        for (Vehicle vehicle : store) {
            if (vehicle.getId() == id && vehicle.getSize() == size) {
                result = vehicle;
                countFreePlaces = countFreePlaces + resize(vehicle);
                break;
            }
        }
        return result;
    }
}
