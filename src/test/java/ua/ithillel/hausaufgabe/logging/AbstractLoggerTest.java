package ua.ithillel.hausaufgabe.logging;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static ua.ithillel.hausaufgabe.logging.LoggingLevel.DEBUG;
import static ua.ithillel.hausaufgabe.logging.LoggingLevel.INFO;

class AbstractLoggerTest {

    private final List<String> logs = new ArrayList<>();

    @Test
    void shouldWriteInfoLog() {
        var logger = logger(INFO);
        logger.info("info-message");

        assertThat(logs, hasSize(1));
        assertThat(logs.get(0), endsWith("[INFO] info-message"));
    }

    @Test
    void shouldNotWriteDebugLogOnInfoLevel() {
        var logger = logger(INFO);
        logger.debug("debug-message");

        assertThat(logs, hasSize(0));
    }

    @Test
    void shouldWriteDebugLog() {
        var logger = logger(DEBUG);
        logger.debug("debug-message");

        assertThat(logs, hasSize(1));
        assertThat(logs.get(0), endsWith("[DEBUG] debug-message"));
    }

    @Test
    void shouldWriteDebugAndInfoLogsOnDebugLevel() {
        var logger = logger(DEBUG);
        logger.debug("debug-message");
        logger.info("info-message");

        assertThat(logs, hasSize(2));
        assertThat(logs.get(0), endsWith("[DEBUG] debug-message"));
        assertThat(logs.get(1), endsWith("[INFO] info-message"));
    }


    private AbstractLogger logger(LoggingLevel loggingLevel) {
        return new AbstractLogger(loggingLevel) {
            @Override
            protected void writeLogEntry(String logEntry) {
                logs.add(logEntry);
            }
        };
    }
}