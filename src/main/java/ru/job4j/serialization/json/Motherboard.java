package ru.job4j.serialization.json;

import java.util.Arrays;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "MotherBoard")
@XmlAccessorType(XmlAccessType.FIELD)
public class Motherboard {
    @XmlAttribute
    private boolean m2;
    @XmlAttribute
    private int ram;
    @XmlAttribute
    private String formFactor;
    private Chipset chipset;
    @XmlElementWrapper(name = "videoOutputs")
    @XmlElement(name = "videoOutput")
    private String[] videoOutputs;

    public Motherboard() { }

    public Motherboard(boolean m2, int ram, String formFactor, Chipset chipset, String[] videoOutputs) {
        this.m2 = m2;
        this.ram = ram;
        this.formFactor = formFactor;
        this.chipset = chipset;
        this.videoOutputs = videoOutputs;
    }

    public boolean getM2() {
        return m2;
    }

    public void setM2(boolean m2) {
        this.m2 = m2;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public Chipset getChipset() {
        return chipset;
    }

    public void setChipset(Chipset chipset) {
        this.chipset = chipset;
    }

    public String[] getVideoOutputs() {
        return videoOutputs;
    }

    public void setVideoOutputs(String[] videoOutputs) {
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
