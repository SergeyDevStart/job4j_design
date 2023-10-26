package ru.job4j.serialization.xml;

import ru.job4j.serialization.json.Chipset;
import ru.job4j.serialization.json.Motherboard;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class MainForXml {
    public static void main(String[] args) throws JAXBException, IOException {
        Motherboard motherboard = new Motherboard(false, 64, "ATX",
                new Chipset("Intel H610"), new String[]{"DVI-D", "DisplayPort", "VGA", "HDMI"});
        JAXBContext context = JAXBContext.newInstance(Motherboard.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(motherboard, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Motherboard result = (Motherboard) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}