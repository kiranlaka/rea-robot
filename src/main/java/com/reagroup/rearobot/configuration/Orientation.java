package com.reagroup.rearobot.configuration;

/**
 * Created by dchrist on 04.04.2016.
 */
public enum Orientation {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270);

    private int degrees;

    Orientation(int degrees) {
        this.degrees = degrees;
    }

    public int degrees() {
        return this.degrees;
    }

    public Orientation left() {
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                throw new IllegalStateException("Orientation unknown: " + this + "(" + this.degrees + ")");
        }
    }

    public Orientation right() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalStateException("Orientation unknown: " + this + "(" + this.degrees + ")");
        }
    }
}
