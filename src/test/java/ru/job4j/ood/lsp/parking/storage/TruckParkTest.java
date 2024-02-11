package ru.job4j.ood.lsp.parking.storage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.model.Truck;
import ru.job4j.ood.lsp.parking.model.Vehicle;

import static org.assertj.core.api.Assertions.*;

@Disabled
class TruckParkTest {
    @Test
    public void whenCheckSizeTruckThenTrue() {
        ParkSystem truckPark = new TruckPark(1);
        Vehicle truck = new Truck(1, 2);
        assertThat(truckPark.checkSizeVehicle(truck)).isTrue();
    }

    @Test
    public void whenCheckSizeCarThenFalse() {
        ParkSystem truckPark = new TruckPark(1);
        Vehicle car = new Car(1);
        assertThat(truckPark.checkSizeVehicle(car)).isFalse();
    }

    @Test
    public void whenAddTruckThenTrue() {
        ParkSystem truckPark = new TruckPark(1);
        Vehicle truck = new Truck(1, 2);
        assertThat(truckPark.parkVehicle(truck)).isTrue();
        assertThat(truckPark.findAll()).contains(truck);
    }

    @Test
    public void whenAddTruckAndGetTruckThenSuccessfully() {
        ParkSystem truckPark = new TruckPark(1);
        Vehicle truck = new Truck(1, 2);
        assertThat(truckPark.getVehicle(1)).isEqualTo(truck);
    }

    @Test
    public void whenGetFreePlacesThen3() {
        ParkSystem truckPark = new TruckPark(5);
        Vehicle truck1 = new Truck(1, 2);
        Vehicle truck2 = new Truck(2, 4);
        truckPark.parkVehicle(truck1);
        truckPark.parkVehicle(truck2);
        assertThat(truckPark.getFreePlaces()).isEqualTo(3);
    }
}