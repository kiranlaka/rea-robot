package com.reagroup.rearobot.robot;

import com.reagroup.rearobot.command.Command;
import com.reagroup.rearobot.command.PlaceCommand;
import com.reagroup.rearobot.configuration.Configuration;
import com.reagroup.rearobot.configuration.Position;
import com.reagroup.rearobot.configuration.Transition;

import java.util.logging.Logger;

/**
 * Created by dchrist on 04.04.2016.
 */
class RobotImpl implements Robot {
    private final static Logger LOGGER = Logger.getLogger(RobotImpl.class.getName());
    private final Position boundary;

    private Configuration configuration;

    RobotImpl(Configuration configuration, Position boundary) {
        this.boundary = boundary;
        this.configuration = configuration;
    }

    @Override
    public Transition apply(Command command) {
        if (this.configuration == null && !(command instanceof PlaceCommand)) {
            LOGGER.info("Not placed yet, skipping command.");
            return new Transition(null, command, null);
        }

        Configuration oldConfiguration = this.configuration;
        Configuration newConfiguration = command.apply(this.configuration);

        if (this.isValidConfiguration(newConfiguration)) {
            this.configuration = newConfiguration;
            return new Transition(oldConfiguration, command, newConfiguration);
        } else {
            LOGGER.warning("New configuration would be invalid, not changing.");
            return new Transition(oldConfiguration, command, oldConfiguration);
        }

    }

    public Configuration configuration() {
        return configuration;
    }

    public Position boundary() {
        return boundary;
    }

    @Override
    public String toString() {
        return "Current robot configuration: " +
                (configuration != null ? configuration.toString() : "Not placed yet");
    }

    private boolean isValidConfiguration(Configuration configuration) {
        Position position = configuration.position();
        return position.x() >= 0 &&
                position.y() >= 0 &&
                position.x() < boundary.x() &&
                position.y() < boundary.y();
    }

}
