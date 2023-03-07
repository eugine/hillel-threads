package ua.ithillel.logging;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class FileLoggerConfigurationLoader {

    @SneakyThrows
    public static FileLoggerConfiguration load(String configPath) {
        var props = new Properties();
        props.load(FileLoggerConfiguration.class.getResourceAsStream(configPath));

        var path = (String) props.get("path");
        var level = LogLevel.valueOf(props.get("level").toString());
        var maxSize = Integer.parseInt(props.get("max-size").toString());

        return new FileLoggerConfiguration(path, level, maxSize);
    }

    public static void main(String[] args) {
        FileLoggerConfiguration config = load("/logs-config.properties");

        System.out.println(config);
    }

}
