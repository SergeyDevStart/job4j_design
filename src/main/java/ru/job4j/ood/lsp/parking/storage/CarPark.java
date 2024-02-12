package ru.job4j.ood.lsp.parking.storage;

import ru.job4j.ood.lsp.parking.model.Vehicle;

public class CarPark extends Park {
    public CarPark(int size) {
        super(size);
    }

    @Override
    public int resize(Vehicle vehicle) {
        return vehicle.getSize();
    }

    @Override
    public boolean checkSizeVehicle(Vehicle vehicle) {
        return vehicle.getSize() >= 1 && vehicle.getSize() <= countFreePlaces;
    }
}
