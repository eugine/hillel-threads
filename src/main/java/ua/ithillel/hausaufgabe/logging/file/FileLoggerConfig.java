package ua.ithillel.hausaufgabe.logging.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import ua.ithillel.hausaufgabe.logging.LoggingLevel;

public record FileLoggerConfig(
        String path,
        @JsonProperty("logging-level")
        LoggingLevel loggingLevel,
        @JsonProperty("max-file-size")
        int logFileMaxSize) {
}
