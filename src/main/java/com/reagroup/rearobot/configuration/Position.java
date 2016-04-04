package com.reagroup.rearobot.configuration;

/**
 * Created by dchrist on 04.04.2016.
 */
public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    @Override
    public String toString() {
        return "(" + this.x() + ", " + this.y() + ")";
    }
}
