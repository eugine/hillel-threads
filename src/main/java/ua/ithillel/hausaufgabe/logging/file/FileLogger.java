package ua.ithillel.hausaufgabe.logging.file;

import ua.ithillel.hausaufgabe.logging.AbstractLogger;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.util.Comparator.comparing;
import static java.util.Objects.requireNonNull;

public class FileLogger extends AbstractLogger {
    private final FileLoggerConfig config;
    private Path currentFile;

    public FileLogger(FileLoggerConfig config) {
        super(config.loggingLevel());
        this.config = requireNonNull(config);
        ensureLogDirExists(config);
    }

    private void ensureLogDirExists(FileLoggerConfig config) {
        var logDir = Path.of(config.path()).toFile();
        if (!logDir.exists() && !logDir.mkdirs()) {
            throw new RuntimeException(String.format("Logs output dirs %s doesn't exist and can't be created", config.path()));
        }
    }

    @Override
    protected void writeLogEntry(String logEntry) {
        byte[] bytes = logEntry.getBytes(UTF_8);
        try (var output = getOutputStream(bytes.length)) {
            output.write(bytes);
            output.write("\n".getBytes(UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Can't write to log entry", e);
        }
    }

    private OutputStream getOutputStream(int bytesToWrite) throws IOException {
        var countLogsToday = countTodayLogFiles();
        if (currentFile == null) {
            if (countLogsToday > 0) {
                var latestLogFileToday = getTodayLogFiles()
                        .max(comparing(Path::getFileName))
                        .orElseThrow();

                if (Files.size(latestLogFileToday) + bytesToWrite <= config.logFileMaxSize()) {
                    currentFile = latestLogFileToday;
                } else {
                    currentFile = initCurrentFile(countLogsToday + 1);
                }

            } else {
                currentFile = initCurrentFile(1);
            }
        } else {
            if (Files.size(currentFile) + bytesToWrite >= config.logFileMaxSize()) {
                currentFile = initCurrentFile(countLogsToday + 1);
            }
        }
        return Files.newOutputStream(currentFile, CREATE, APPEND);
    }

    private int countTodayLogFiles() throws IOException {
        return (int) getTodayLogFiles().count();
    }

    private Stream<Path> getTodayLogFiles() throws IOException {
        var todayFilesPrefix = String.format("output_%s_", LocalDate.now());
        return Files.list(Path.of(config.path()))
                .filter(Files::isRegularFile)
                .filter(file -> file.toFile().getName().startsWith(todayFilesPrefix));
    }

    private Path initCurrentFile(int index) {
        var fileName = String.format("output_%s_%03d.log", LocalDate.now(), index);
        return Path.of(config.path(), fileName);
    }
}
