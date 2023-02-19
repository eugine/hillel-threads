package ua.ithillel.hausaufgabe.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

public class YamlUtils {
    public static final String FILE_LOGGER_CONFIG_PATH = "/file-logger.yml";

    public static <T> T load(String resourcePath, Class<T> clazz) {
        try {
            return new ObjectMapper(new YAMLFactory())
                    .readValue(YamlUtils.class.getResourceAsStream(resourcePath), clazz);
        } catch (IOException e) {
            throw new RuntimeException("Can't local file logger config", e);
        }
    }

}
