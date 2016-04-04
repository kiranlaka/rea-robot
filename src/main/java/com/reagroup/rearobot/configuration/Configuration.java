package com.reagroup.rearobot.configuration;

/**
 * Created by dchrist on 04.04.2016.
 */
public class Configuration {

    private final Orientation orientation;
    private final Position position;

    public Configuration(Position position, Orientation orientation) {
        this.orientation = orientation;
        this.position = position;
    }

    public Orientation orientation() {
        return this.orientation;
    }

    public Position position() {
        return this.position;
    }

    @Override
    public String toString() {
        return "Position: " + this.position() + ", Orientation: " + this.orientation();
    }

}
