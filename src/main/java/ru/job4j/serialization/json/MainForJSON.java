package ru.job4j.serialization.json;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.json.*;

public class MainForJSON {
    public static void main(String[] args) {
        JSONObject jsonChipset = new JSONObject("{\"chipset\":\"XYZ\"}");
        List<String> list = new ArrayList<>(Arrays.asList("X", "Y", "Z"));
        JSONArray jsonVideoOutputs = new JSONArray(list);
        final Motherboard motherboard = new Motherboard(false, 64, "ATX",
                new Chipset("Intel H610"), new String[] {"DVI-D", "DisplayPort", "VGA", "HDMI"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("m2", motherboard.getM2());
        jsonObject.put("ram", motherboard.getRam());
        jsonObject.put("formFactor", motherboard.getFormFactor());
        jsonObject.put("chipset", jsonChipset);
        jsonObject.put("videoOutputs", jsonVideoOutputs);
        System.out.println(jsonObject);
        System.out.println(new JSONObject(motherboard));
    }
}
