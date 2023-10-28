package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "chipset")
public class Chipset {
    @XmlAttribute
    private String chipset;

    public Chipset() { }

    public Chipset(String chipset) {
        this.chipset = chipset;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    @Override
    public String toString() {
        return "Chipset{"
                + "chipset='" + chipset + '\''
                + '}';
    }
}
