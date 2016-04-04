package com.reagroup.rearobot.command;

import com.reagroup.rearobot.configuration.Configuration;
import com.reagroup.rearobot.configuration.Position;

/**
 * Created by dchrist on 04.04.2016.
 */
public class MoveCommand implements Command {
    @Override
    public Configuration apply(Configuration configuration) {
        switch (configuration.orientation()) {
            case NORTH:
                return new Configuration(configuration.position().x(), configuration.position().y() + 1, configuration.orientation());
            case EAST:
                return new Configuration(configuration.position().x() + 1, configuration.position().y(), configuration.orientation());
            case SOUTH:
                return new Configuration(configuration.position().x(), configuration.position().y() - 1, configuration.orientation());
            case WEST:
                return new Configuration(configuration.position().x() - 1, configuration.position().y(), configuration.orientation());
            default:
                throw new IllegalStateException("Orientation unknown: " + configuration.orientation());
        }
    }
}
