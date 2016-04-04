package com.reagroup.rearobot.command;

import com.reagroup.rearobot.configuration.Configuration;

public class LeftCommand implements Command {
    @Override
    public Configuration apply(Configuration configuration) {
        return new Configuration(configuration.position(), configuration.orientation().left());
    }
}
