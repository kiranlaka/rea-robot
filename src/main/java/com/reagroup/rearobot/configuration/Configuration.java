package com.reagroup.rearobot.configuration;

/**
 * Created by dchrist on 04.04.2016.
 */
public class Configuration {

    private final Orientation orientation;
    private final Position position;

    public Configuration(int x, int y, Orientation orientation) {
        this.orientation = orientation;
        this.position = new Position(x, y);
    }

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
    public int hashCode() {
        int result = 77;
        result = 31 * result + this.orientation().hashCode();
        result = 31 * result + this.position().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Configuration)) {
            return false;
        }
        Configuration conf = (Configuration) obj;
        return this.orientation() == conf.orientation() && this.position().equals(conf.position());
    }

    @Override
    public String toString() {
        return "Position: " + this.position() + ", Orientation: " + this.orientation();
    }

}
