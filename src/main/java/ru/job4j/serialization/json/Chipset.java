package ru.job4j.serialization.json;

public class Chipset {
    private final String chipset;

    Chipset(String chipset) {
        this.chipset = chipset;
    }

    @Override
    public String toString() {
        return "Chipset{"
                + "chipset='" + chipset + '\''
                + '}';
    }
}
