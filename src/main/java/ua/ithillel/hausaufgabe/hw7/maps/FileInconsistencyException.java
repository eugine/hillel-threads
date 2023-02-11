package ua.ithillel.hausaufgabe.hw7.maps;

public class FileInconsistencyException extends RuntimeException {
    private final String fsPath;
    private final FileData file;
    public FileInconsistencyException(String fsPath, FileData file) {
        super(String.format("File inconsistency between fs path %s and file path %s", fsPath, file.path()));
        this.fsPath = fsPath;
        this.file = file;
    }

    public String getFsPath() {
        return fsPath;
    }

    public FileData getFile() {
        return file;
    }
}
