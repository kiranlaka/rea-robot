package com.reagroup.rearobot.robot;

import com.reagroup.rearobot.command.Command;
import com.reagroup.rearobot.configuration.Configuration;
import com.reagroup.rearobot.configuration.Position;
import com.reagroup.rearobot.configuration.Transition;

import java.util.function.Function;

/**
 * A robot for the toy robot simulator challenge.
 */
public interface Robot extends Function<Command, Transition> {
    /**
     * Applies a command to the robot.
     *
     * @param command The command the robot should execute.
     * @return The transition the robot did due to the command.
     */
    @Override
    Transition apply(Command command);

    /**
     * @return The current configuration of the robot, or null if not yet placed.
     */
    Configuration configuration();

    /**
     * @return The boundaries of the tabletop provided to the robot.
     */
    Position boundary();
}
