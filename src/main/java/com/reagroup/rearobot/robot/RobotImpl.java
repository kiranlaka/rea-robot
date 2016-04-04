package com.reagroup.rearobot.robot;

import com.reagroup.rearobot.command.Command;
import com.reagroup.rearobot.configuration.Configuration;
import com.reagroup.rearobot.configuration.Position;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.logging.Logger;

/**
 * Created by dchrist on 04.04.2016.
 */
class RobotImpl implements Robot {
    private final static Logger LOGGER = Logger.getLogger(RobotImpl.class.getName());

    private Configuration configuration;
    private final Position boundary;

    RobotImpl(Configuration configuration, Position boundary) {
        this.boundary = boundary;
        this.configuration = configuration;
    }

    @Override
    public Configuration apply(Command command) {
        Configuration newConfiguration = command.apply(this.configuration);
        if (this.isValidConfiguration(newConfiguration)) {
            this.configuration = newConfiguration;
        } else {
            LOGGER.warning("New configuration would be invalid, not changing.");
        }
        return this.configuration;
    }

    @Override
    public String toString() {
        return "Current robot configuration: " + configuration;
    }

    private boolean isValidConfiguration(Configuration newConfiguration) {
        throw new NotImplementedException();
    }

}
