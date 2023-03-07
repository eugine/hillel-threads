package ua.ithillel.logging;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.nio.charset.StandardCharsets.UTF_8;

public abstract class AbstractLogger implements Logger {

    private final LogLevel level;

    protected AbstractLogger(LogLevel level) {
        this.level = level;
    }

    public void debug(String message) {
        if (level == LogLevel.INFO) {
            return;
        }
        log(message, LogLevel.DEBUG);
    }

    public void info(String message) {
        log(message, LogLevel.INFO);
    }

    private void log(String message, LogLevel level) {
        var time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd-HH:mm:ss"));
        var outputMessage = String.format("%s [%s] Message: %s", time, level, message);
        log(outputMessage);
    }

    protected abstract void log(String formattedMessage);

}
