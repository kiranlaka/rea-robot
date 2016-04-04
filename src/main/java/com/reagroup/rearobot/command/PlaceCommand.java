package com.reagroup.rearobot.command;

import com.reagroup.rearobot.configuration.Configuration;
import com.reagroup.rearobot.configuration.Orientation;

/**
 * The place command will output the configuration provided in the constructor,
 * no matter what the input was.
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
