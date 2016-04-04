package com.reagroup.rearobot.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Created by dchrist on 04.04.2016.
 */
public class Input implements Function<String[], Stream<String>> {
    private final static Logger LOGGER = Logger.getLogger(Input.class.getName());

    @Override
    public Stream<String> apply(String[] args) {
        switch (args.length) {
            case 0:
                return stdinStream();
            case 1:
                return fileStream(args[0]);
            default:
                LOGGER.severe("Invalid number of arguments. Must be either empty or one filename.");
                return Stream.empty();
        }
    }

    private Stream<String> fileStream(String filePath) {
        try {
            return Files.lines(Paths.get(filePath));
        } catch (IOException e) {
            LOGGER.severe("File " + filePath + " could not be read.");
            return Stream.empty();
        }
    }

    private Stream<String> stdinStream() {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();

        while (scanner.hasNext()) {
            result.add(scanner.nextLine());
        }

        return result.stream();
    }
}
