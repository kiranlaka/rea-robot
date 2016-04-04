package com.reagroup.rearobot.command;

import com.reagroup.rearobot.configuration.Configuration;

/**
 * Created by dchrist on 04.04.2016.
 */
public class ReportCommand implements Command {
    @Override
    public Configuration apply(Configuration configuration) {
        return configuration;
    }
}
