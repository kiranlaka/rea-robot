package com.reagroup.rearobot.configuration;

/**
 * Created by dchrist on 04.04.2016.
 */
public enum Orientation {
    NORTH,
    EAST,
    SOUTH,
    WEST;

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
                throw new IllegalStateException("Orientation unknown: " + this);
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
                throw new IllegalStateException("Orientation unknown: " + this);
        }
    }

}
