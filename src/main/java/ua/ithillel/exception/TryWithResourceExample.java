package ua.ithillel.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResourceExample {

    public void oldStyle() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public void tryWithResourceExample() {
        //AutoCloseable interface
    }
}
