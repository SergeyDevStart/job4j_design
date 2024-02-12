package ru.job4j.ood.lsp.parking.storage;

import ru.job4j.ood.lsp.parking.model.Vehicle;

public class TruckPark extends Park {
    public TruckPark(int size) {
        super(size);
    }

    @Override
    public int resize(Vehicle vehicle) {
        return 1;
    }

    @Override
    public boolean checkSizeVehicle(Vehicle vehicle) {
        return vehicle.getSize() > 1 && countFreePlaces >= 1;
    }
}
