package ru.job4j.ood.lsp.parking.storage;

import ru.job4j.ood.lsp.parking.model.Vehicle;

import java.util.List;

public interface ParkSystem {
    List<Vehicle> findAll();

    boolean checkSizeVehicle(Vehicle vehicle);

    int getFreePlaces();

    boolean parkVehicle(Vehicle vehicle);

    Vehicle getVehicle(int id);
}
