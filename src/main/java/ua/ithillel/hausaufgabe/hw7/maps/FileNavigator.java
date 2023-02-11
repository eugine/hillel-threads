package ua.ithillel.hausaufgabe.hw7.maps;

import java.util.*;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class FileNavigator {

    private final Map<String, List<FileData>> fs = new HashMap<>();

    public void add(String fsPath, FileData file) {
        if (!Objects.equals(fsPath, file.path())) {
            throw new FileInconsistencyException(fsPath, file);
        }
        fs.computeIfAbsent(fsPath, (key) -> new ArrayList<>())
                .add(file);
    }

    public List<FileData> find(String fsPath) {
        return fs.get(fsPath);
    }

    /**
     * Return all files in certain path smaller than maxSize
     */
    public List<FileData> filterBySize(String fsPath, long maxSize) {
        return Optional.ofNullable(fs.get(fsPath)).orElseGet(List::of).stream()
                .filter(file -> file.size() <= maxSize)
                .sorted(comparing(FileData::name))
                .collect(toList());
    }

    /**
     * Return all files in FS that are smaller than maxSize
     */
    public List<FileData> filterAllBySize(long maxSize) {
        return getAllFiles(file -> file.size() <= maxSize,
                comparing(FileData::path).thenComparing(FileData::name));
    }

    /**
     * Return all files in FS sorted by size
     */
    public List<FileData> sortBySize() {
        return getAllFiles(file -> true, comparing(FileData::size));
    }

    private List<FileData> getAllFiles(Predicate<FileData> filter, Comparator<FileData> sorting) {
        return fs.values().stream()
                .flatMap(Collection::stream)
                .filter(filter)
                .sorted(sorting)
                .toList();
    }

    public List<FileData> remove(String fsPath) {
        return fs.remove(fsPath);
    }

    protected Map<String, List<FileData>> getAll() {
        return fs;
    }

}
