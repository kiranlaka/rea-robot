package com.reagroup.rearobot;

import com.reagroup.rearobot.configuration.Orientation;
import com.reagroup.rearobot.configuration.Position;
import com.reagroup.rearobot.input.CommandCreator;
import com.reagroup.rearobot.input.Input;
import com.reagroup.rearobot.input.Sanitizer;
import com.reagroup.rearobot.robot.Robot;
import com.reagroup.rearobot.robot.RobotBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dchrist on 04.04.2016.
 */
public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        setUpLogging();

        LOGGER.info("Hello World!");
        Robot robot = new RobotBuilder()
                .initialPosition(new Position(0, 0), Orientation.NORTH)
                .northEastBoundary(new Position(5, 5))
                .build();

        new Input().apply(args)
                .map(new Sanitizer())
                .map(new CommandCreator())
                .map(robot)
                // TODO: only print if command was report
                .forEach(System.out::println);
    }

    private static void setUpLogging() {
        Logger rootLog = Logger.getLogger("");
        rootLog.setLevel(Level.FINE);
        rootLog.getHandlers()[0].setLevel(Level.FINE);
    }

}
