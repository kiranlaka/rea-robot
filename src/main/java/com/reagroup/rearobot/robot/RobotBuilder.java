package com.reagroup.rearobot.robot;

import com.reagroup.rearobot.configuration.Configuration;
import com.reagroup.rearobot.configuration.Orientation;
import com.reagroup.rearobot.configuration.Position;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by dchrist on 04.04.2016.
 */
public class RobotBuilder {

    private Position boundary;
    private Configuration configuration;

    public void initialPosition(Configuration configuration) {
        this.configuration = configuration;
    }

    public void initialPosition(Position position, Orientation orientation) {
        this.configuration = new Configuration(position, orientation);
    }

    public void northEastBoundary(Position position) {
        this.boundary = position;
    }

    public Robot build() {
        if (this.configuration == null || this.boundary == null) {
            throw new IllegalStateException("Not all necessary fields are set.");
        }
        return new RobotImpl(this.configuration, this.boundary);
    }

}
