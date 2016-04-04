package com.reagroup.rearobot.input;

import com.reagroup.rearobot.command.*;
import com.reagroup.rearobot.configuration.Orientation;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dchrist on 04.04.2016.
 */
public class CommandParser implements Function<String, Command> {

    private static final String LEFT = "LEFT";
    private static final String MOVE = "MOVE";
    private static final String PLACE_PREFIX = "PLACE";
    private static final Pattern PLACE_REGEX = Pattern.compile(PLACE_PREFIX + " (\\d+),(\\d+),(\\w+)");
    private static final String REPORT = "REPORT";
    private static final String RIGHT = "RIGHT";
    private static final String NORTH = "NORTH";
    private static final String EAST = "EAST";
    private static final String SOUTH = "SOUTH";
    private static final String WEST = "WEST";

    @Override
    public Command apply(String commandString) {
        if (commandString == null) {
            throw new IllegalArgumentException("Empty command");
        } else if (commandString.equals(LEFT)) {
            return new LeftCommand();
        } else if (commandString.equals(MOVE)) {
            return new MoveCommand();
        } else if (commandString.startsWith(PLACE_PREFIX)) {
            return this.parsePlaceCommand(commandString);
        } else if (commandString.equals(REPORT)) {
            return new ReportCommand();
        } else if (commandString.equals(RIGHT)) {
            return new RightCommand();
        } else {
            throw new IllegalArgumentException("Unknown command: " + commandString);
        }
    }

    private Command parsePlaceCommand(String commandString) {
        Matcher matcher = PLACE_REGEX.matcher(commandString);
        if (matcher.matches()) {
            return new PlaceCommand(
                    Integer.parseInt(matcher.group(1)),
                    Integer.parseInt(matcher.group(2)),
                    this.parsePlaceCommandOrientation(matcher.group(3))
            );
        } else {
            throw new IllegalArgumentException("Unknown command: " + commandString);
        }
    }

    private Orientation parsePlaceCommandOrientation(String orientationString) {
        if (orientationString == null) {
            throw new IllegalArgumentException("Empty orientation");
        } else if (orientationString.equals(NORTH)) {
            return Orientation.NORTH;
        } else if (orientationString.equals(EAST)) {
            return Orientation.EAST;
        } else if (orientationString.equals(SOUTH)) {
            return Orientation.SOUTH;
        } else if (orientationString.equals(WEST)) {
            return Orientation.WEST;
        } else {
            throw new IllegalArgumentException("Unknown orientation: " + orientationString);
        }
    }
}
