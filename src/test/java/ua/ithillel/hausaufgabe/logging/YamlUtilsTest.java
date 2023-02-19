package ua.ithillel.hausaufgabe.logging;

import org.junit.jupiter.api.Test;
import ua.ithillel.hausaufgabe.logging.file.FileLoggerConfig;

import static org.junit.jupiter.api.Assertions.*;
import static ua.ithillel.hausaufgabe.logging.LoggingLevel.DEBUG;

class YamlUtilsTest {

    @Test
    void shouldLoadYaml() {
        var config = YamlUtils.load("/yaml-file-loader-test.yml", FileLoggerConfig.class);

        assertEquals(config, new FileLoggerConfig("test-logs", DEBUG, 234));
    }
}