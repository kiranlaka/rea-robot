package com.reagroup.rearobot.command;

import com.reagroup.rearobot.configuration.Configuration;
import com.reagroup.rearobot.configuration.Orientation;

/**
 * Created by dchrist on 04.04.2016.
 */
public class PlaceCommand implements Command {

    private final Configuration configuration;

    public PlaceCommand(int x, int y, Orientation orientation) {
        this(new Configuration(x, y, orientation));
    }

    public PlaceCommand(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Configuration apply(Configuration configuration) {
        return this.configuration;
    }
}
