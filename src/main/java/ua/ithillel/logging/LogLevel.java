package ua.ithillel.logging;

public enum LogLevel {
    INFO("Info"),
    DEBUG("Debug");

    private final String value;

    LogLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
