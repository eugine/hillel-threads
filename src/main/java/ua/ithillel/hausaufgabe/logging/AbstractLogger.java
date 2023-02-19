package ua.ithillel.hausaufgabe.logging;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.SECONDS;
import static java.util.Objects.requireNonNull;
import static ua.ithillel.hausaufgabe.logging.LoggingLevel.DEBUG;
import static ua.ithillel.hausaufgabe.logging.LoggingLevel.INFO;

public abstract class AbstractLogger implements Logger {
    private static final Map<LoggingLevel, List<LoggingLevel>> ALLOWED_LEVELS = Map.of(
            DEBUG, List.of(DEBUG, INFO),
            INFO, List.of(INFO)
    );

    protected final List<LoggingLevel> allowedLevels;

    public AbstractLogger(LoggingLevel loggingLevel) {
        this.allowedLevels = requireNonNull(ALLOWED_LEVELS.get(loggingLevel));
    }

    public void debug(String message) {
        log(DEBUG, message);
    }

    public void info(String message) {
        log(INFO, message);
    }

    protected void log(LoggingLevel level, String message) {
        if (allowedLevels.contains(level)) {
            writeLogEntry(String.format("[%s] [%s] %s", LocalDateTime.now().truncatedTo(SECONDS), level, message));
        }
    }

    protected abstract void writeLogEntry(String logEntry);

}
