package com.reagroup.rearobot.command;

import com.reagroup.rearobot.configuration.Configuration;

import java.util.function.UnaryOperator;

/**
 * Created by dchrist on 04.04.2016.
 */
public interface Command extends UnaryOperator<Configuration> {
}
