package com.reagroup.rearobot.input;

import com.reagroup.rearobot.command.Command;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.function.Function;

/**
 * Created by dchrist on 04.04.2016.
 */
public class CommandParser implements Function<String, Command> {
    @Override
    public Command apply(String s) {
        throw new NotImplementedException();
    }
}
