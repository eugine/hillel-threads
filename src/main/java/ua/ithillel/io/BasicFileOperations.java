package ua.ithillel.io;

import ua.ithillel.hausaufgabe.hw7.maps.FileNavigator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class BasicFileOperations {

    public static void basic() throws IOException {
//        Path path = Path.of("src", "main", "resources", "hw3-words.db");
        Path path = Path.of("src/main/resources/hw3-words.db");
        System.out.println("absolute path: " + path.toAbsolutePath());


//        File file = path.toFile();
        File file = new File("src/main/resources/hw3-words.db");

        file.getName();
        file.exists();
        file.mkdirs();
//        file.delete();

        Files.size(path);
        Files.list(path);
        Files.isDirectory(path);
    }

    public static void readFileWithInputStream() {
        try (var is = new FileInputStream("src/main/resources/hw3-words.db")) {
            byte[] bytes = is.readAllBytes();
            System.out.println(new String(bytes, UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFileWithReader() {
        var path = Path.of("src/main/resources/hw3-words.db");
        try (var is = new InputStreamReader(new FileInputStream(path.toFile()))){
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readWithScanner() throws IOException {
//        var scanner = new Scanner(System.in);
//        var scanner = new Scanner( new FileInputStream(Path.of("src/main/resources/hw3-words.db").toFile()));
//        while (scanner.hasNext()) {
//            System.out.println("line: " + scanner.nextLine());
//        }
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/hw3-words.db"));
        System.out.println(lines);
    }


    public static void writeToFileWithOutputStream() {
        try (var out = new FileOutputStream("out/1.txt")) {
            out.write("message".getBytes(UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFileWithWriter() throws FileNotFoundException {
        try (var out = new OutputStreamWriter(new FileOutputStream("out/2.txt"))) {
            out.write("message");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFromResources() {
        try (var is = BasicFileOperations.class.getResourceAsStream("/hw3-words.db")) {
            byte[] bytes = is.readAllBytes();
            System.out.println(new String(bytes, UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void other() throws IOException {
        Files.readAllLines(Path.of("src/main/resources/hw3-words.db"));
    }

    public static void main(String[] args) throws IOException {
//        basic();

//        readFileWithInputStream();
//        readFileWithReader();
//        readWithScanner();

//        writeToFileWithOutputStream();
//        writeToFileWithWriter();
        readFromResources();
    }


}
