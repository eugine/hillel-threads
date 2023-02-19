package ua.ithillel.hausaufgabe.logging.console;

import ua.ithillel.hausaufgabe.logging.AbstractLogger;
import ua.ithillel.hausaufgabe.logging.LoggingLevel;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(LoggingLevel loggingLevel) {
        super(loggingLevel);
    }

    @Override
    protected void writeLogEntry(String logEntry) {
        System.out.println(logEntry);
    }
}
