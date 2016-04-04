package com.reagroup.rearobot.input;

import java.util.function.UnaryOperator;

/**
 * Created by dchrist on 04.04.2016.
 */
public class Sanitizer implements UnaryOperator<String> {
    @Override
    public String apply(String s) {
        return s.trim().toUpperCase();
    }
}
