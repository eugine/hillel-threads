package ua.ithillel.hausaufgabe.logging;

import ua.ithillel.hausaufgabe.logging.file.FileLogger;
import ua.ithillel.hausaufgabe.logging.file.FileLoggerConfig;

import static ua.ithillel.hausaufgabe.logging.YamlUtils.FILE_LOGGER_CONFIG_PATH;

public class Main {
    public static void main(String[] args) {
        var logger = getLogger();
//        var logger = new ConsoleLogger(LoggingLevel.DEBUG);

        for (int i = 0; i < 100; i++) {
            logger.debug("Debug message");
            logger.info("Info message");
        }
    }

    private static Logger getLogger() {
        return new FileLogger(YamlUtils.load(FILE_LOGGER_CONFIG_PATH, FileLoggerConfig.class));
    }
}
