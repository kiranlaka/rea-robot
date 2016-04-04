package com.reagroup.rearobot.robot;

import com.reagroup.rearobot.configuration.Configuration;
import com.reagroup.rearobot.configuration.Orientation;
import com.reagroup.rearobot.configuration.Position;

/**
 * Created by dchrist on 04.04.2016.
 */
public class RobotBuilder {

    private Position boundary;
    private Configuration configuration;

    public RobotBuilder initialConfiguration(Configuration configuration) {
        this.configuration = configuration;
        return this;
    }

    public RobotBuilder initialConfiguration(Position position, Orientation orientation) {
        this.initialConfiguration(new Configuration(position, orientation));
        return this;
    }

    public RobotBuilder northEastBoundary(Position position) {
        this.boundary = position;
        return this;
    }

    public Robot build() {
        if (this.boundary == null) {
            throw new IllegalStateException("No boundaries for movement are set.");
        }
        return new RobotImpl(this.configuration, this.boundary);
    }

}
