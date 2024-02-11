package ru.job4j.ood.lsp.parking.manager;

import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.model.Truck;
import ru.job4j.ood.lsp.parking.model.Vehicle;
import ru.job4j.ood.lsp.parking.storage.CarPark;
import ru.job4j.ood.lsp.parking.storage.ParkSystem;
import ru.job4j.ood.lsp.parking.storage.TruckPark;

import java.util.List;

public class ParkingManager {
    private final ParkSystem carPark;
    private final ParkSystem truckPark;

    public ParkingManager(int sizeCar, int sizeTruck) {
        this.carPark = new CarPark(sizeCar);
        this.truckPark = new TruckPark(sizeTruck);
    }

    public boolean parkAuto(Vehicle vehicle) {
        return false;
    }

    public Car getCar(int id) {
        return null;
    }

    public Truck getTruck(int id) {
        return null;
    }

    public int getFreePlacesForCar() {
        return 0;
    }

    public int getFreePlacesForTruck() {
        return 0;
    }

    public List<Vehicle> findAll() {
        return null;
    }
}