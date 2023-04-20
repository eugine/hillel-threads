package ua.ithillel.utils;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    @SneakyThrows
    public static String loadFile(String path) {
        return new String(Files.readAllBytes(Path.of(path)));
    }
}
