package com.reagroup.rearobot.robot;

import com.reagroup.rearobot.command.Command;
import com.reagroup.rearobot.configuration.Configuration;
import com.reagroup.rearobot.configuration.Position;
import com.reagroup.rearobot.configuration.Transition;

import java.util.function.Function;

/**
 * Created by dchrist on 04.04.2016.
 */
public interface Robot extends Function<Command, Transition> {
    Configuration configuration();
    Position boundary();
}
