package com.reagroup.rearobot.command;

import com.reagroup.rearobot.configuration.Configuration;

/**
 * Returns the unmodified input, thus causes no configuration change.
 * Used as null-object in fault cases.
 */
public class NullCommand implements Command {
    @Override
    public Configuration apply(Configuration configuration) {
        return configuration;
    }
}
