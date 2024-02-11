package ru.job4j.ood.lsp.parking.storage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.model.Truck;
import ru.job4j.ood.lsp.parking.model.Vehicle;

import static org.assertj.core.api.Assertions.*;

@Disabled
class CarParkTest {
    @Test
    public void whenCheckSizeCarThenTrue() {
        ParkSystem carPark = new CarPark(1);
        Vehicle car = new Car(1);
        assertThat(carPark.checkSizeVehicle(car)).isTrue();
    }

    @Test
    public void whenCheckSizeTruckThenFalse() {
        ParkSystem carPark = new CarPark(1);
        Vehicle truck = new Truck(1, 2);
        assertThat(carPark.checkSizeVehicle(truck)).isFalse();
    }

    @Test
    public void whenAddCarThenTrue() {
        ParkSystem carPark = new CarPark(1);
        Vehicle car = new Car(1);
        assertThat(carPark.parkVehicle(car)).isTrue();
        assertThat(carPark.findAll()).contains(car);
    }

    @Test
    public void whenAddCarAndGetCarThenSuccessfully() {
        ParkSystem carPark = new CarPark(1);
        Vehicle car = new Car(1);
        assertThat(carPark.getVehicle(1)).isEqualTo(car);
    }

    @Test
    public void whenGetFreePlacesThen3() {
        ParkSystem carPark = new CarPark(5);
        Vehicle car1 = new Car(1);
        Vehicle car2 = new Car(2);
        carPark.parkVehicle(car1);
        carPark.parkVehicle(car2);
        assertThat(carPark.getFreePlaces()).isEqualTo(3);
    }
}