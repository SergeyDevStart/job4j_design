package ru.job4j.ood.lsp.parking.model;

import java.util.Objects;

public abstract class Vehicle {
    private final int id;
    protected int size;

    public Vehicle(int id) {
        this.id = id;
        this.size = 1;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id && size == vehicle.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size);
    }
}
