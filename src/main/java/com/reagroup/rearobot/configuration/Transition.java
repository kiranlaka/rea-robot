package com.reagroup.rearobot.configuration;

import com.reagroup.rearobot.command.Command;
import com.reagroup.rearobot.configuration.Configuration;

/**
 * Created by dchrist on 04.04.2016.
 */
public class Transition {
    private final Configuration from;
    private final Command by;
    private final Configuration to;

    public Transition(Configuration from, Command by, Configuration to) {
        this.from = from;
        this.by = by;
        this.to = to;
    }

    public Configuration from() {
        return from;
    }

    public Command by() {
        return by;
    }

    public Configuration to() {
        return to;
    }

}
