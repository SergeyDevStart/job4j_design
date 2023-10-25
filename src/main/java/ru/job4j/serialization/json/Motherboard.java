package ru.job4j.serialization.json;

import java.util.Arrays;

public class Motherboard {
    private final boolean m2;
    private final int ram;
    private final String formFactor;
    private final Chipset chipset;
    private final String[] videoOutputs;

    public Motherboard(boolean m2, int ram, String formFactor, Chipset chipset, String[] videoOutputs) {
        this.m2 = m2;
        this.ram = ram;
        this.formFactor = formFactor;
        this.chipset = chipset;
        this.videoOutputs = videoOutputs;
    }

    @Override
    public String toString() {
        return "Motherboard{"
                + "m2=" + m2
                + ", ram=" + ram
                + ", formFactor='" + formFactor + '\''
                + ", chipset=" + chipset
                + ", videoOutputs=" + Arrays.toString(videoOutputs)
                + '}';
    }
}
