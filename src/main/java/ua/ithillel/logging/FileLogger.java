package ua.ithillel.logging;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileLogger extends AbstractLogger {

    private final FileLoggerConfiguration configuration;
    private File currentFile;
    private int nextFileIndex = 1;

    public FileLogger(FileLoggerConfiguration configuration) {
        super(configuration.level());
        this.configuration = configuration;
        try {
            Files.createDirectories(Path.of(configuration.path()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        currentFile = new File(configuration.path() + "/output_" + (nextFileIndex++) + ".log");
    }


    @SneakyThrows
    protected void log(String outputMessage) {
        var fileSize = Files.exists(currentFile.toPath()) ? Files.size(currentFile.toPath()) : 0;
        if (fileSize + outputMessage.getBytes(UTF_8).length > configuration.maxSize()) {
            currentFile =  new File(configuration.path() + "/output_" + (nextFileIndex++) + ".log");
        }

        try (var writer = new FileWriter(currentFile, true)) {
            writer.write(outputMessage);
            writer.write("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        var config = new FileLoggerConfiguration("hillel-logs", LogLevel.INFO, 100);
        Logger logger = new FileLogger(config);

        logger.info("some message ");
        logger.info("some message ");
        logger.info("some message ");
        logger.info("some message ");
        logger.info("some message ");
        logger.info("some message ");
        logger.info("some message ");
        logger.info("some message ");
        logger.debug("some message ");
    }

}
