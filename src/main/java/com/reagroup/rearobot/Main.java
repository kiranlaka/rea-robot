package com.reagroup.rearobot;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dchrist on 04.04.2016.
 */
public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        setUpLogging();

        LOGGER.info("Hello World!");
    }

    private static void setUpLogging() {
        Logger rootLog = Logger.getLogger("");
        rootLog.setLevel(Level.FINE);
        rootLog.getHandlers()[0].setLevel(Level.FINE);
    }

}
