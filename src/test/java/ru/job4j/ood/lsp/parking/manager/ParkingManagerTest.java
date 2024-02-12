package ru.job4j.ood.lsp.parking.manager;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.model.Truck;
import ru.job4j.ood.lsp.parking.model.Vehicle;
import static org.assertj.core.api.Assertions.*;

class ParkingManagerTest {
    @Test
    public void whenAddCarThenTrue() {
        ParkingManager manager = new ParkingManager(1, 0);
        Vehicle car = new Car(1);
        assertThat(manager.parkAuto(car)).isTrue();
        assertThat(manager.findAll()).contains(car);
    }

    @Test
    public void whenAddCarThenFalse() {
        ParkingManager manager = new ParkingManager(0, 0);
        Vehicle car = new Car(1);
        assertThat(manager.parkAuto(car)).isFalse();
    }

    @Test
    public void whenAddTruckThenTrue() {
        ParkingManager manager = new ParkingManager(0, 1);
        Vehicle truck = new Truck(1, 2);
        assertThat(manager.parkAuto(truck)).isTrue();
        assertThat(manager.findAll()).contains(truck);
    }

    @Test
    public void whenAddTruckThenFalse() {
        ParkingManager manager = new ParkingManager(0, 0);
        Vehicle truck = new Truck(1, 2);
        assertThat(manager.parkAuto(truck)).isFalse();
    }

    @Test
    public void whenAddTruckAndCarAndFindAllThenSuccessfully() {
        ParkingManager manager = new ParkingManager(1, 1);
        Vehicle car = new Car(1);
        Vehicle truck = new Truck(1, 2);
        manager.parkAuto(car);
        manager.parkAuto(truck);
        assertThat(manager.findAll()).contains(car, truck);
    }

    @Test
    public void whenAddTruckThenMustParkInTheCarPark() {
        ParkingManager manager = new ParkingManager(2, 0);
        Vehicle truck = new Truck(1, 2);
        assertThat(manager.parkAuto(truck)).isTrue();
        assertThat(manager.findAll()).contains(truck);
    }

    @Test
    public void whenAddCarThenFreePlaces2() {
        ParkingManager manager = new ParkingManager(3, 0);
        Vehicle car = new Car(1);
        manager.parkAuto(car);
        assertThat(manager.getFreePlacesForCar()).isEqualTo(2);
    }

    @Test
    public void whenAddTruckThenFreePlaces2() {
        ParkingManager manager = new ParkingManager(0, 3);
        Vehicle truck = new Truck(1, 3);
        manager.parkAuto(truck);
        assertThat(manager.getFreePlacesForTruck()).isEqualTo(2);
    }

    @Test
    public void whenAddTruckAndCarThenFreePlacesForCar1() {
        ParkingManager manager = new ParkingManager(4, 0);
        Vehicle truck = new Truck(1, 2);
        Vehicle car = new Car(1);
        manager.parkAuto(truck);
        manager.parkAuto(car);
        assertThat(manager.getFreePlacesForCar()).isEqualTo(1);
    }

    @Test
    public void whenGetCarThenSuccessfully() {
        ParkingManager manager = new ParkingManager(1, 0);
        Vehicle car = new Car(1);
        manager.parkAuto(car);
        assertThat(manager.getCar(1, 1)).isEqualTo(car);
    }

    @Test
    public void whenGetCarThenNotSuccessfully() {
        ParkingManager manager = new ParkingManager(1, 0);
        Vehicle car = new Car(1);
        manager.parkAuto(car);
        assertThat(manager.getCar(2, 1)).isNull();
    }

    @Test
    public void whenGetCarThenFreePlaces1() {
        ParkingManager manager = new ParkingManager(1, 0);
        Vehicle car = new Car(1);
        manager.parkAuto(car);
        manager.getCar(1, 1);
        assertThat(manager.getFreePlacesForCar()).isEqualTo(1);
    }

    @Test
    public void whenAdd2TruckThenFreePlaces0() {
        ParkingManager manager = new ParkingManager(2, 1);
        Vehicle truck1 = new Truck(1, 2);
        Vehicle truck2 = new Truck(2, 2);
        manager.parkAuto(truck1);
        manager.parkAuto(truck2);
        assertThat(manager.getFreePlacesForTruck()).isEqualTo(0);
        assertThat(manager.getFreePlacesForCar()).isEqualTo(0);
    }

    @Test
    public void whenAddTruckInTheCarParkAndGetTruckThenSuccessfully() {
        ParkingManager manager = new ParkingManager(2, 0);
        Vehicle truck = new Truck(1, 2);
        manager.parkAuto(truck);
        assertThat(manager.getTruck(1, 2)).isEqualTo(truck);
    }
}