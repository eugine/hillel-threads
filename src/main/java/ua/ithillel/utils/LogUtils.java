package ua.ithillel.utils;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.MILLIS;

public class LogUtils {
    public static void log(String message, Object... params) {
        var formattedMessage = String.format(message, params);
        System.out.println(String.format("%s [%s] %s",
                LocalDateTime.now().truncatedTo(MILLIS), Thread.currentThread().getName(), formattedMessage));
    }
}
