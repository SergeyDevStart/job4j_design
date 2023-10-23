package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte byteType = Byte.MAX_VALUE;
        short shortType = Short.MAX_VALUE;
        int intType = Integer.MAX_VALUE;
        long longType = Long.MAX_VALUE;
        float floatType = Float.MAX_VALUE;
        double doubleType = Double.MAX_VALUE;
        char charType = 'J';
        boolean booleanType = true;
        LOG.debug("Info Log: byte {}, short {}, int {}, long {}, float {}, double {}, char {}, boolean {}",
                byteType, shortType, intType,
                longType, floatType, doubleType, charType, booleanType);
    }
}
