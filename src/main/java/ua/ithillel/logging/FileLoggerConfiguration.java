package ua.ithillel.logging;

public record FileLoggerConfiguration(
        String path,
        LogLevel level,
        int maxSize
) {

}
