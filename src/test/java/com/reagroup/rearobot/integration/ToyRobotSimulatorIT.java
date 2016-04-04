package com.reagroup.rearobot.integration;

import com.reagroup.rearobot.command.ReportCommand;
import com.reagroup.rearobot.configuration.Configuration;
import com.reagroup.rearobot.configuration.Position;
import com.reagroup.rearobot.configuration.Transition;
import com.reagroup.rearobot.input.CommandParser;
import com.reagroup.rearobot.input.Sanitiser;
import com.reagroup.rearobot.robot.Robot;
import com.reagroup.rearobot.robot.RobotBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ToyRobotSimulatorIT {

    private Robot robot;

    @Before
    public void setUp() {
        this.robot = new RobotBuilder()
                .mandatoryNorthEastBoundary(new Position(5, 5))
                .build();
    }

    @Test
    public void testInputA() throws Exception {
        assertEquals("0,1,NORTH", runSimulator("PLACE 0,0,NORTH", "MOVE", "REPORT"));
    }

    @Test
    public void testInputB() throws Exception {
        assertEquals("0,0,WEST", runSimulator("PLACE 0,0,NORTH", "LEFT", "REPORT"));
    }

    @Test
    public void testInputC() throws Exception {
        assertEquals("3,3,NORTH", runSimulator("PLACE 1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT"));
    }

    private String runSimulator(String... commands) {
        List<String> output = Stream.of(commands)
                .map(new Sanitiser())
                .map(new CommandParser())
                .map(this.robot)
                .filter(transition -> transition.by() instanceof ReportCommand)
                .map(Transition::to)
                .map(Configuration::toString)
                .collect(Collectors.toList());
        assertEquals(1, output.size());
        return output.get(0);
    }

}
