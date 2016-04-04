package com.reagroup.rearobot.command;

import com.reagroup.rearobot.configuration.Configuration;

/**
 * Created by dchrist on 04.04.2016.
 */
public class LeftCommand implements Command {
    @Override
    public Configuration apply(Configuration configuration) {
        return new Configuration(configuration.position(), configuration.orientation().left());
    }
}
