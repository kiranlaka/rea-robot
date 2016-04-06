package com.reagroup.rearobot.command;

import com.reagroup.rearobot.configuration.Configuration;

public class LeftCommand extends AbstractCommand {
    @Override
    public Configuration applyInternal(Configuration configuration) {
        return new Configuration(configuration.position(), configuration.orientation().left());
    }
}
