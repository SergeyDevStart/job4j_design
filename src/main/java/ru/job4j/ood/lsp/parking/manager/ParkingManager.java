package ru.job4j.ood.lsp.parking.manager;

import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.model.Truck;
import ru.job4j.ood.lsp.parking.model.Vehicle;
import ru.job4j.ood.lsp.parking.storage.CarPark;
import ru.job4j.ood.lsp.parking.storage.ParkSystem;
import ru.job4j.ood.lsp.parking.storage.TruckPark;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    private final ParkSystem carPark;
    private final ParkSystem truckPark;

    public ParkingManager(int sizeCar, int sizeTruck) {
        this.carPark = new CarPark(sizeCar);
        this.truckPark = new TruckPark(sizeTruck);
    }

    public boolean parkAuto(Vehicle vehicle) {
        return truckPark.parkVehicle(vehicle) || carPark.parkVehicle(vehicle);
    }

    public Car getCar(int id, int size) {
        return (Car) carPark.getVehicle(id, size);
    }

    public Truck getTruck(int id, int size) {
        Truck result;
        result = (Truck) truckPark.getVehicle(id, size);
        if (result == null) {
            result = (Truck) carPark.getVehicle(id, size);
        }
        return result;
    }

    public int getFreePlacesForCar() {
        return carPark.getFreePlaces();
    }

    public int getFreePlacesForTruck() {
        return truckPark.getFreePlaces();
    }

    public List<Vehicle> findAll() {
        List<Vehicle> result = new ArrayList<>();
        result.addAll(carPark.findAll());
        result.addAll(truckPark.findAll());
        return result;
    }
}
