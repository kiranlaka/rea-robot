package com.reagroup.rearobot;

import com.reagroup.rearobot.command.ReportCommand;
import com.reagroup.rearobot.configuration.Position;
import com.reagroup.rearobot.input.CommandParser;
import com.reagroup.rearobot.input.Input;
import com.reagroup.rearobot.input.Sanitizer;
import com.reagroup.rearobot.robot.Robot;
import com.reagroup.rearobot.robot.RobotBuilder;
import com.reagroup.rearobot.configuration.Transition;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dchrist on 04.04.2016.
 */
public class Main {

    private static final Position BOUNDARY = new Position(4, 4);

    public static void main(String[] args) {
        setUpLogging();
        Robot robot = buildRobot();
        runSimulator(args, robot);
    }

    private static void runSimulator(String[] args, Robot robot) {
        new Input().apply(args)
                .map(new Sanitizer())
                .map(new CommandParser())
                .map(robot)
                .filter(transition -> transition.by() instanceof ReportCommand)
                .map(Transition::to)
                .forEach(System.out::println);
    }

    private static Robot buildRobot() {
        return new RobotBuilder()
                .mandatoryNorthEastBoundary(BOUNDARY)
                .build();
    }

    private static void setUpLogging() {
        Logger rootLog = Logger.getLogger("");
        rootLog.setLevel(Level.FINE);
        rootLog.getHandlers()[0].setLevel(Level.FINE);
    }

}
