package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Motherboard motherboard = new Motherboard(false, 64, "ATX",
                new Chipset("Intel H610"), new String[] {"DVI-D", "DisplayPort", "VGA", "HDMI"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(motherboard));

        final String newGsonString = "{\"m2\":false, \"ram\":32, \"formFactor\":\"ATX\","
                + "\"chipset\":{\"chipset\":\"XXX\"}, \"videoOutputs\":[\"x\", \"y\", \"z\"]}";
        final Motherboard motherboardMod = gson.fromJson(newGsonString, Motherboard.class);
        System.out.println(motherboardMod);
    }
}
