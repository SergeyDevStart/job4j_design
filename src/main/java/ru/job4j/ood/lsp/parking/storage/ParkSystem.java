package ru.job4j.ood.lsp.parking.storage;

import ru.job4j.ood.lsp.parking.model.Vehicle;

public interface ParkSystem {
    int getFreePlaces();

    boolean parkVehicle(Vehicle vehicle);

    Vehicle getVehicle(int id);
}
