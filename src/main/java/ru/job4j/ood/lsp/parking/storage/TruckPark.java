package ru.job4j.ood.lsp.parking.storage;

import ru.job4j.ood.lsp.parking.model.Vehicle;

public class TruckPark extends Park {
    public TruckPark(int size) {
        super(size);
    }

    @Override
    public boolean checkSizeVehicle(Vehicle vehicle) {
        return false;
    }
}
